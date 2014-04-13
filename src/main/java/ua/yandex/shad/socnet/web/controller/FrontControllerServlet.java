/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Amdrii
 */
public class FrontControllerServlet extends HttpServlet {

    private ApplicationContext appCtx;

    @Override
    public void init() {
        System.out.println("Start Loading Spring Context");
        String webContext = getServletConfig().getServletName() + ".xml";
        System.out.println(webContext);
        String applicationContext = getServletContext().getInitParameter("applicationContext");
        System.out.println(applicationContext);
        appCtx = new ClassPathXmlApplicationContext(webContext, applicationContext);
        System.out.println("Finish Loading Spring Context");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String view = null;

        System.out.println("processRequest");

        Controller controller = getController(request);
        try {
            view = controller.handleRequest(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        dispatch(request, response, view);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException {
        String prefix = "/WEB-INF/view/";
        String sufix = ".jsp";
        System.out.println(prefix + view + sufix);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(prefix + view + sufix);
        dispatcher.forward(request, response);
    }
    
    private Controller getController(HttpServletRequest request) {
        System.out.println(request.getPathInfo());
        return appCtx.getBean(request.getPathInfo(), Controller.class);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
