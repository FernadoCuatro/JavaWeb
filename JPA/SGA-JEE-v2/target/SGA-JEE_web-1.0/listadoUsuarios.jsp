<%-- 
    Document   : listadoPersonas
    Created on : 5 nov. 2022, 10:10:02
    Author     : Fernando Cuatro
--%>


<%--
    Crear conexion a base de datos de MySQL por medio de NetBeans
    Para crear la conexion desde Netbeans, pegamos el .jar en la direccion de la carpeta donde esta el proyecto POR EJEMPLO
    
    Services -> DataBases -> Nueva conexion -> La opcion de MySQl y todo lo de siempre.
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
            <c:forEach items="${usuarios}" var="usuario">
                <li>${usuario.idUsuario} - ${usuario.username}. Persona: ${usuario.persona}</li>
            </c:forEach>
        </ul>
        
    </body>
</html>
