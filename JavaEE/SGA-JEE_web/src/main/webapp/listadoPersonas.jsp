<%-- 
    Document   : listadoPersonas
    Created on : 5 nov. 2022, 10:10:02
    Author     : Fernando Cuatro
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>La lista de personas, esta aqui!</h1>
        
        <ul>
            <c:forEach items="${personas}" var="persona">
                <li>${persona.nombre} ${persona.apellido} -- ${persona.email}</li>
            </c:forEach>
        </ul>
        
    </body>
</html>
