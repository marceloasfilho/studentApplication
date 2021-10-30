package br.com.projeto.awesome.repository;

import br.com.projeto.awesome.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface StudentDAO extends PagingAndSortingRepository<Student, Long> {
    List<Student> findByNameIgnoreCaseContaining(String name);

    Optional<Student> findById(Long id);
}
