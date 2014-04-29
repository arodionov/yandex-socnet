/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.yandex.shad.socnet.web.usermanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    private final String LOGIN_PAGE = "LoginPage";
    private final String LOGIN_REDIRECT = "redirect:loginpage";
    private final String VIEW_ALL_REDIRECT = "redirect:viewall";
    
    @Autowired
    private UserManager userManager;
    
    @RequestMapping("/loginpage")
    public String login(){
        return LOGIN_PAGE;
    }
    
    @RequestMapping("/login")
    public String tryToLogin(@RequestParam String user){
        //UserManager um = ac.getBean("userManager", UserManager.class);
        //System.out.println(um.getUser());       
        if (user == null) return LOGIN_PAGE;
        if (userManager.isLoggedIn()) return VIEW_ALL_REDIRECT;
        userManager.login(user);        
        return VIEW_ALL_REDIRECT;
    }
    
    @RequestMapping("/logout")
    public String logout(){        
        userManager.logout();
        return LOGIN_REDIRECT;
    }
    
}
