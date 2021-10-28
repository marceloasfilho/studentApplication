package br.com.projeto.awesome.repository;

import br.com.projeto.awesome.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentDAO extends CrudRepository<Student, Long> {
    List<Student> findByNameIgnoreCaseContaining(String name);
    Optional<Student> findById(Long id);
}
