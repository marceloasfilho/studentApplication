package br.com.projeto.awesome.endpoint;

import br.com.projeto.awesome.exception.ResourceNotFoundException;
import br.com.projeto.awesome.model.Student;
import br.com.projeto.awesome.repository.StudentDAO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

    private final StudentDAO studentDAO;

    public StudentEndpoint(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listAll")
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(this.studentDAO.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "{name}")
    public ResponseEntity<?> getStudentsByName(@PathVariable("name") String name) {
        List<Student> foundStudents = this.studentDAO.findByNameIgnoreCaseContaining(name);
        if (foundStudents.size() > 0) {
            return new ResponseEntity<>(foundStudents, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(foundStudents, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
        checkIfStudentExists(id);
        Optional<Student> result = this.studentDAO.findById(id);
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(this.studentDAO.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/deleteById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        checkIfStudentExists(id);
        this.studentDAO.deleteById(id);
        return new ResponseEntity<>(this.listAll(PageRequest.of(0, 5)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        this.studentDAO.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void checkIfStudentExists(Long id) {
        if (!this.studentDAO.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Student not found for id: " + id);
        }
    }
}
