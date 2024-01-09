<%-- 
    Document   : alcanceVariables
    Created on : 12 sept. 2022, 17:59:04
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcace variables JSP</title>
    </head>
    <body>
        <h1>Variables de request:</h1>
        <p>Base: ${rectanguloRequest.base}</p>
        <p>Altura: ${rectanguloRequest.altura}</p>
        <p>Area: ${rectanguloRequest.area}</p>
        
        <br/>
        
        <h1>Variables de session:</h1>
        <p>Base: ${rectanguloSesion.base}</p>
        <p>Altura: ${rectanguloSesion.altura}</p>
        <p>Area: ${rectanguloSesion.area}</p>
        
        <br/>
        
        <h1>Variables de Application</h1>
        <p>Base: ${rectanguloAplicacion.base}</p>
        <p>Altura: ${rectanguloAplicacion.altura}</p>
        <p>Area: ${rectanguloAplicacion.area}</p>
        
        <br/>
        
        <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
        
    </body>
</html>
