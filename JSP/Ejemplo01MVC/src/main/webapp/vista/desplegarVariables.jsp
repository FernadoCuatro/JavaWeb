<%-- 
    Document   : desplegarVariables
    Created on : 12 sept. 2022, 17:12:50
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue</title>
    </head>
    <body>
        <h1>Despliegue de variables - MVC</h1>
        <p>Variable en alcance Request: ${mensaje}</p>
        
        <p>Variable de alcance de sesion:</p>
        
        <h1>Rectangulo:</h1>
        <p>Base: ${rectangulo.base}</p>
        <p>Altura ${rectangulo.altura}</p>
        <p>Area: ${rectangulo.area}</p>
        
        <br/>
        
        <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
    </body>
</html>
