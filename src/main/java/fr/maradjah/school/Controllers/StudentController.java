package fr.maradjah.school.Controllers;

import fr.maradjah.school.Services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("student",studentService.getStudentById(new Long(id)));

        return "student/show";
    }
}
