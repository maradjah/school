package fr.maradjah.school.Repositories;

import fr.maradjah.school.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findByFirstName(String firstName);
    Optional<Student> findById(long id);
}
