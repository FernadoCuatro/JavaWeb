<%-- 
    Document   : clientes
    Created on : 18 sept. 2022, 23:32:37
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Control de clientes</title>

        <%-- Bootstrap css --%>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
    </head>
    <body>
        <%-- Header --%>
        <%-- Incluimos la pagina de header --%>
        <jsp:include page="/WEB-INF/templates/estructura/header.jsp" />
        
        <%-- Botones de navegacion --%>
        <jsp:include page="/WEB-INF/templates/estructura/menu.jsp" />
        
        <%-- Listado de clientes --%>
        <jsp:include page="/WEB-INF/templates/cliente/listadoClientes.jsp" />
        
        <%-- Agregar cliente modal --%>
        <jsp:include page="/WEB-INF/templates/cliente/agregarCliente.jsp" />
        
        <%-- Footer --%>
        <jsp:include page="/WEB-INF/templates/estructura/footer.jsp" />
        
        <%-- fontawesome --%>
        <script src="https://kit.fontawesome.com/d21a3be417.js" crossorigin="anonymous"></script>
        
        <%-- source-files Bootstrap --%>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
    </body>
</html>
