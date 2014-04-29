/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.web.usermanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    
    @Autowired
    private UserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //System.out.println(uri);
        if (!uri.endsWith("loginpage") && !uri.endsWith("login") && !uri.endsWith("logout")) {           
            if (!userManager.isLoggedIn()) {
                response.sendRedirect("loginpage");
                return false;
            }
            //System.out.println(userManager.getUser());
        }
        return true;
    }
}
