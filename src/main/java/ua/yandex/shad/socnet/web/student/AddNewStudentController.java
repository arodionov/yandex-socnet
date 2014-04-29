package ua.yandex.shad.socnet.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.service.student.StudentService;

@Controller
@RequestMapping("/addstudent")
public class AddNewStudentController {
    
    private final StudentService studentService;

    @Autowired
    public AddNewStudentController(StudentService studentService) {
        this.studentService = studentService;
    }    
    
    @ModelAttribute
    private Student createStudent(
            @RequestParam String sName, 
            @RequestParam Integer sYear) {
        //System.out.println(sName +" "+sYear);
        return new Student(sName, sYear);
    }
    
    @RequestMapping
    public String addStudent(@ModelAttribute Student student) {
        //System.out.println(student);
        if (!studentService.checkIfExists(student)) {
            studentService.create(student);
        }
        return "redirect:viewall";
    }
    
}
