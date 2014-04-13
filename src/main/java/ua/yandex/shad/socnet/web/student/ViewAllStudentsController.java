/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.yandex.shad.socnet.repository.student.StudentRepository;
import ua.yandex.shad.socnet.service.student.StudentService;
import ua.yandex.shad.socnet.web.controller.Controller;

/**
 *
 * @author Amdrii
 */
public class ViewAllStudentsController implements Controller {

    private final StudentService studentService;

    public ViewAllStudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        request.setAttribute("students", studentService.findAll());

        return "ViewAllStudents";
    }

}
