<%-- 
    Document   : expresiones
    Created on : 2 sept. 2022, 18:44:30
    Author     : Fernando Cuatro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Se podria eliminar la directiva, ya que aqui se esta declarando tambien -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con expresiones</title>
    </head>
    <body>
        <h1>JSP con expresiones</h1>
        
        <p>Concatenacion: <%= "Saludos" + " <b>name</b> " + " desde JSP." %></p>
        <p>Operacion Matematica: <%= 2 * 3 /2 %> </p>
        <p>Sesion id: <%= session.getId() %></p>
        
        <br/><br/><br/>
        
        <a href="index.html">Volver al inicio HTML</a>
         
    </body>
</html>
