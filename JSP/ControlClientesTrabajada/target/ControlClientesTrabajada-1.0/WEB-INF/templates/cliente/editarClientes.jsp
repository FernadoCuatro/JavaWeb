<%-- 
    Document   : editarClientes
    Created on : 24 sept. 2022, 14:35:33
    Author     : Fernando Cuatro
--%>

<%-- Usamos la directiva: --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Editar cliente</title>

        <%-- Bootstrap css --%>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
    </head>
    <body>
        <%-- Header --%>
        <%-- Incluimos la pagina de header --%>
        <jsp:include page="/WEB-INF/templates/estructura/header.jsp" />

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}" method="post" class="was-validated">
            <%-- Botones de navegacion --%>
            <jsp:include page="/WEB-INF/templates/estructura/menuGuardar.jsp" />
            
            <div class="col-md-6" style="margin:0 auto">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" name="nombre" id="nombre" required value="${cliente.nombreCliente}">
                </div>

                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" name="apellido" id="apellido" required value="${cliente.apellidoCliente}">
                </div>

                <div class="form-group">
                    <label for="email">Correo electrónico:</label>
                    <input type="email" class="form-control" name="email" id="email" required value="${cliente.emailCliente}">
                </div>

                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" class="form-control" name="telefono" id="telefono" required value="${cliente.telefonoCliente}">
                </div>

                <div class="form-group">
                    <label for="saldo">Saldo:</label>
                    <input type="decimal" class="form-control" name="saldo" id="saldo" required value="${cliente.saldoCliente}">
                </div>
            </div>

        </div>
    </form>

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
