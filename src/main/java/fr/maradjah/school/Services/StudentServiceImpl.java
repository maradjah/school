package fr.maradjah.school.Services;

import fr.maradjah.school.Repositories.StudentRepository;
import fr.maradjah.school.models.Student;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> getStudents() {
        Set<Student> studentSet = new HashSet<>();
        studentRepository.findAll().iterator().forEachRemaining(studentSet::add);
        return studentSet;
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(!studentOptional.isPresent()){
            throw new RuntimeException("Student not found");
        }
        return studentOptional.get();
    }

}
