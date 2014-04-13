/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import ua.yandex.shad.socnet.service.student.StudentService;
import ua.yandex.shad.socnet.web.controller.Controller;

/**
 *
 * @author Amdrii
 */
public class ViewStudentController implements Controller{
    
    private final StudentService studentService;

    @Autowired
    public ViewStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //System.out.println();
        Integer id = Integer.parseInt(request.getParameter("studid"));        
        request.setAttribute("student",studentService.findByID(id));   
        
        return "ViewStudent";
    }
    
}
