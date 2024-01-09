<%-- 
    Document   : menu
    Created on : 24 sept. 2022, 11:22:17
    Author     : Fernando Cuatro
--%>

<%-- mb = margin-bottom de 4 es decir 1.5 --%>
<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-block bg-light"><i class="fas fa-arrow-left" aria-hidden="true"></i> Volver</a>
            </div>
            
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}" type="submit" class="btn btn-block btn-danger"><i class="fa fa-trash-o" aria-hidden="true"></i> Eliminar</a>
            </div>
            
            <div class="col-md-3">
                <button type="submit" class="btn btn-block btn-success"><i class="fa fa-user" aria-hidden="true"></i> Guardar cambios</button>
            </div>
        </div>
    </div>
</section>
