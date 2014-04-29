package ua.yandex.shad.socnet.web.usermanager;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("userManager")
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
//Please read docs: 
//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html#beans-factory-scopes-other-injection
public class StandardUserManager implements Serializable, UserManager{
    
    private String user;
    private boolean loggedIn;

    @Override
    public String getUser() {
        return user;
    }
    
    @Override
    public void login(String user){        
        this.user = user;
        loggedIn = true;
    }
    
    @Override
    public void logout(){
        this.user = null;
        loggedIn = false;
    }
    
    @Override
    public boolean isLoggedIn(){
        return loggedIn;
    }
  
}
