/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.yandex.shad.socnet.service.student.StudentService;
import ua.yandex.shad.socnet.web.student.ViewAllStudentsController;
import ua.yandex.shad.socnet.web.student.ViewStudentController;

/**
 *
 * @author Amdrii
 */
public class ControllerFactory {

    private static final Map<String,Controller> controllers;
    static{
        System.out.println("Start Loading Spring Context");
        ApplicationContext appCtx = 
                new ClassPathXmlApplicationContext("persistenceContext.xml");
        System.out.println("Finish Loading Spring Context");
        
        StudentService studentService = appCtx.getBean("StudentService", StudentService.class);
        
        controllers = new HashMap<String, Controller>();
        controllers.put("/viewall", new ViewAllStudentsController(studentService));
        controllers.put("/viewstudent", new ViewStudentController(studentService));
    //    controllers.put("/updatestudent", null);
    }
    
    public static Controller getController(HttpServletRequest request) {
        System.out.println(request.getPathInfo());
        return controllers.get(request.getPathInfo());
    }
}
