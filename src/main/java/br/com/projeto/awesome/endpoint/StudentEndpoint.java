package br.com.projeto.awesome.endpoint;

import br.com.projeto.awesome.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    @RequestMapping(method = RequestMethod.GET, path = "/listAll")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(Student.friends, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
        Student desired = new Student();
        desired.setId(id);
        int index = Student.friends.indexOf(desired);

        if (index >= 0) {
            return new ResponseEntity<>(Student.friends.get(index), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found with id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student){
        Student.friends.add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Student student){
        Student.friends.remove(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update (@RequestBody Student student){
        Student.friends.remove(student);
        Student.friends.add(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
