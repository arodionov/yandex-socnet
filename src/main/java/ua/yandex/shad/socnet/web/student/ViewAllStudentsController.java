/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ua.yandex.shad.socnet.service.student.StudentService;


/**
 *
 * @author Amdrii
 */
public class ViewAllStudentsController implements Controller {

    private final StudentService studentService;

    @Autowired
    public ViewAllStudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        //request.setAttribute("students", studentService.findAll());

        return new ModelAndView("ViewAllStudents", "students", studentService.findAll());
    }

}
