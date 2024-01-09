<%-- 
    Document   : index
    Created on : 12 sept. 2022, 17:18:35
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC 02</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC 02</h1>

        <div style="color: red">
            ${mensaje}
        </div>

        <a href="${pageContext.request.contextPath}/ServletControlador">
            Servlet controlador sin parametros
        </a>

        <br/>

        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
            Servlet controlador para agregar las variables
        </a>

        <br/>

        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
            Servlet controlador para listar variables
        </a>

    </body>
</html>
