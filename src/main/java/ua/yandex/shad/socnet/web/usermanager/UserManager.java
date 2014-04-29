package ua.yandex.shad.socnet.web.usermanager;

public interface UserManager {

    String getUser();

    boolean isLoggedIn();

    void login(String user);

    void logout();
    
}
