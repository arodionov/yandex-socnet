package ua.yandex.shad.socnet.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.yandex.shad.socnet.service.student.StudentService;
import ua.yandex.shad.socnet.web.usermanager.UserManager;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    private UserManager userManager;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/viewall")
    public String viewAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("user", userManager.getUser());
        return "ViewAllStudents";
    }

    @RequestMapping(value = "/viewstudent",
            method = RequestMethod.GET,
            params = "studid")
    public String viewStudent(Model model,
            @RequestParam("studid") Integer id) {
        model.addAttribute("student", studentService.findByID(id));
        return "ViewStudent";
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.GET,
            params = "studid")
    public String deleteStudent(@RequestParam("studid") Integer id) {
        studentService.delete(id);
        return "redirect:viewall";
    }

    @RequestMapping("/createstudent")
    public String createStudent() {
        return "AddStudent";
    }

}
