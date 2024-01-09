<%-- 
    Document   : index
    Created on : 12 sept. 2022, 17:18:35
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC 01</h1>
 
        <%-- El nombre del path de manera dinamica --%>
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al Servlet Controlador que despliega la variable
        </a>
        
    </body>
</html>
