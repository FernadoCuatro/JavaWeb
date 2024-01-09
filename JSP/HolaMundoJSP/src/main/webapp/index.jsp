<%-- 
    Document   : index
    Created on : 2 sept. 2022, 17:18:48
    Author     : Fernando Cuatro
--%>

<!-- Librerias a utilizar, se declaran aqui arriba con la siguiente directiva -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    
    <body>
        <h1>Hola Mundo!</h1>
        
        <!-- Opciones para trabajar con JSP -->
        <%-- 
            <%   -> ScriptLets      -> Se puede agregar codigo java directamente, con variables ya dispobibles
            <%!  -> Expresion
            <%-- -> De comentarios
            <%=  -> Expresion       -> Es como que si se imprimera un out.print
        --%>
        
        <ul>
            <li><% out.print("Hola mundo con ScriptLets"); %></li>
            <li>${"Hola mundocon Expression Languaje (EL)"}</li>
            <li><%= "Se imprime el caracter de manera explicita" %></li>
            <li><c:out value="Hola mundo con JSTL (Pages Standard Tag Library)"  /></li>
        </ul>
    </body>
</html>
