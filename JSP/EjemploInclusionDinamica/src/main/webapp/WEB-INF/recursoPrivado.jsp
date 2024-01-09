<%-- 
    Document   : recursoPrivado
    Created on : 11 sept. 2022, 20:04:46
    Author     : Fernando Cuatro
--%>

<%-- Para procesar los datos enviados por parametros, los procesamos --%>
<%
    String colorFondo = request.getParameter("color_fondo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: <%= colorFondo %>">
        <h1>Color de fondo activado: <%= colorFondo %></h1>
    </body>
</html>
