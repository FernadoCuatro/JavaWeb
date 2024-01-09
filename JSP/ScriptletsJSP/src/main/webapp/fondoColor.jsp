<%-- 
    Document   : fondoColor
    Created on : 2 sept. 2022, 19:17:16
    Author     : Fernando Cuatro
--%>

<%-- Recuperamos el parametroe enviado desde el formulario --%>
<%
    String fondo = request.getParameter("color_fondo");
    
    if (fondo == null || fondo.trim().equals(""))
    {
        fondo = "#fff";
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP fondo de color dinamico</title>
    </head>
    
    <style>
        .invertido {
            color: <%= fondo %>;
            -webkit-filter: invert(100%);
            filter: invert(100%);
        }
    </style>
    
    <body style="background-color: <%= fondo %>">
        <h1 class="invertido">Fondo de color dinamico</h1>
        
        <p class="invertido">Color de fondo aplicado: <%= fondo %></p>

        <a href="index.html" class="invertido">Volver al HTML</a>
    </body>
</html>
