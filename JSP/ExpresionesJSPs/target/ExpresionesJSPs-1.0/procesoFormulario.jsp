<%-- 
    Document   : procesoFormulario
    Created on : 2 sept. 2022, 18:44:56
    Author     : Fernando Cuatro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Procesa formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el formulario</h1>
        
        <p>Usuario: <%= request.getParameter("usuario") %> </p>
        <p>Password: <%= request.getParameter("password") %> </p>
        
        <br/><br/>
        
        <a href="index.html">Volver al HTML</a>
        
    </body>
</html>
