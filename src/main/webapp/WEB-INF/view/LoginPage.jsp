<%-- 
    Document   : LoginPage
    Created on : Apr 26, 2014, 5:11:44 PM
    Author     : andrii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        
        ${userManager.user}
        
        <form method="post" action="login">
            Name <input type="text" name="user" required="false" /> <br/>
            <input type="submit" value="Login" />
        </form>
        
    </body>
</html>
