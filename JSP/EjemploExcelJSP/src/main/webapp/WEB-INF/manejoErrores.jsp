<%-- 
    Document   : manejoErrores
    Created on : 11 sept. 2022, 12:31:41
    Author     : Fernando Cuatro
--%>

<%-- Indicamos que esta pagina es la que maneja errores --%>
<%@page isErrorPage="true" %>
<%@page import="java.io.*"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de error</title>
    </head>
    <body>
        <style>
            .container {
                display: flex;
                justify-content: center;
                align-content: center;
            }
        </style>

        <div class="container">
            <p>Se produjo un error inesperado</p>
            <p>+info: <%= exception.getMessage() %></p>
            <br/>
            <a href="../index.html" style="margin-bottom: 30px">Volver al inicio</a>
            
            <pre>
                <% exception.printStackTrace(new PrintWriter(out)); %>
            </pre>
        </div>

    </body>
</html>
