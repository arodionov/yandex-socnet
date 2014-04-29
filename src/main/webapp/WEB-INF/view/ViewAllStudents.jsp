<%-- 
    Document   : ViewAllStandart
    Created on : Sep 30, 2013, 2:05:18 PM
    Author     : andrii
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Students</title>
    </head>
    <body>
        <h1>Hello ${user}</h1>       
        <table border="1">
            <thead><tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Year</th>
                </tr></thead>

            <c:forEach var="stud" items="${students}">
                <tr>
                    <td>${stud.studentID}</td> 
                    <td>${stud.studentName}</td> 
                    <td>${stud.studentYear}</td>
                    <td>
                        <form method="get" action="viewstudent" >
                            <input type="hidden" name="studid" value="${stud.studentID}" />
                            <input type="submit" value="Show" />
                        </form>        
                    </td>

                </tr>            
            </c:forEach>
        </table>
        <a href="createstudent"> Create new student </a> <br/>
        <a href="logout"> Logout </a> <br/>
    </body>
</html>
