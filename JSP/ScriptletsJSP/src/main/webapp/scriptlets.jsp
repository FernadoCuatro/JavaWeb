<%-- 
    Document   : Scriptlets
    Created on : 2 sept. 2022, 19:17:40
    Author     : Fernando Cuatro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br/>
        
        <%-- 
            Los comentarios con JSP no se muestran en el navegador 
            Los comentarios con HTML si se muestran en el navegador
        --%>
        
        <%-- Scriptlets para enviar informacion al navegador --%>
        <% out.print("Saludos desde un scriptlets"); %>
            
        <br/><br/>
        
        <%-- Scriptlet para manipular los objetos implicitos --%>
        <% 
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre aplicacion: " + nombreAplicacion);
        %>
        
        <%-- Scriptlet condicionado --%>
        <% if (session != null && session.isNew()) { %>
            <p>La sesion es nueva</p>
        <% } else { %>
            <p>La sesion estaba creada anteriormente</p>
        <% } %>
        
        <a href="index.html">Volver al inicio</a>
       
    </body>
</html>
