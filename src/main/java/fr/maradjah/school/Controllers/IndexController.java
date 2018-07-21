package fr.maradjah.school.Controllers;

import fr.maradjah.school.Repositories.StudentRepository;
import fr.maradjah.school.Services.StudentService;
import fr.maradjah.school.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final StudentService studentService;

    public IndexController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("students",studentService.getStudents());
        return "index";
    }
}
