<%-- 
    Document   : listadoMotoristas
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
        <h1>La lista de motoristas, esta aqui!</h1>
        
        <table>
        <tr>
          <td><strong>DUI</strong></td>
          <td><strong>Nombre del motorista</strong></td>
          <td><strong>Telefono</strong></td>
          <td><strong>Empresa</strong></td>
        </tr>

        <c:forEach items="${motoristas}" var="motorista">
        <tr>
            <td>${motorista.diuMotorista}</td>
            <td>${motorista.nombreMotorista} ${motorista.apellidoMotorista}</td>
            <td>${motorista.telefono}</td>
            <td>${motorista.empresaPertenece}</td>
        </tr>
        </c:forEach>
        
        </table>
        
    </body>
</html>
