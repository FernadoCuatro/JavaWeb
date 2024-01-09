<%-- 
    Document   : setter
    Created on : 12 sept. 2022, 10:08:25
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Beans</title>
    </head>
    <body>
        <h1>Jsp que modifica a Java Beans</h1>
        
        <%-- Utilizamos la accion: --%>
        <%-- Alcances o Scope: Request es el mas basico --%>
        <%-- Session es el siguiente [Media hora o hasta que se termine el programa], y finalmente application [Todo el tiempo que este la aplicacion arriba] --%>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        
        <%-- Seguimos usando acciones --%>
        <%
            int baseValor = 5;
            int alturaValor = 10;
        %>
        
        <%-- Mandamos a llamar la propiedad set, del atributo base de la clase rectangulo --%>
        <jsp:setProperty name="rectangulo" property="base" value="<%= baseValor %>" />
        <jsp:setProperty name="rectangulo" property="altura" value="<%= alturaValor %>" />
        
        <p>Nuevo valor de base: <%= baseValor %></p>
        <p>Nuevo valor de altura: <%= alturaValor %></p>

        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
