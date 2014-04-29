<%-- 
    Document   : AddStudent
    Created on : Apr 25, 2014, 2:58:06 PM
    Author     : andrii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Student</title>
    </head>
    <body>
        <h1>Create New Student</h1>
        <form method="post" action="addstudent">
            Name <input type="text" name="sName" required="true" /> <br/>
            Year <input type="number" name="sYear" required="true" /> <br/>
            <input type="submit" value="Add" />
        </form>
    </body>
</html>
