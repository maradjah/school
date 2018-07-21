package fr.maradjah.school.Services;

import fr.maradjah.school.models.Student;

import java.util.Set;

public interface StudentService {

     Set<Student> getStudents();
     Student getStudentById(long id);
}
