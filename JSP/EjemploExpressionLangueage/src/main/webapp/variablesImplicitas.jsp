<%-- 
    Document   : variablesImplicitas
    Created on : 12 sept. 2022, 12:03:45
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>[EL] Variables implicitas</title>
    </head>
    <body>
        <h1>[EL] Variables implicitas</h1>
        
        <ul>
            <li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
            <li>Tipo de navegador: ${header["User-Agent"]} </li>
            <li>ID Sesion: ${cookie.JSESSIONID.value}</li>
            <li>Informacion del Web Server: ${pageContext.servletContext.serverInfo} </li>
            <li>Nombre de mi preciosa: ${param.usuario} </li>
            <li>Nombre de mi amor: ${param["usuario"]} </li>
        </ul>
        
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
