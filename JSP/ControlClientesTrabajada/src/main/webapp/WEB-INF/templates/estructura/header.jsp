<%-- 
    Document   : header
    Created on : 24 sept. 2022, 11:05:00
    Author     : Fernando Cuatro
--%>

<%-- p es de padding, y es para modificar el superior e inferior y el 2 es un size de 0.5 --%>
<header id="main-header" class="py-2 bg-primary text-white">
    <div class="container">
        <div class="row">
            <%-- En boostrap se trabaja con el sistema de 12 columnas --%>
            <div class="col-md-6">
                <h1><a href="${pageContext.request.contextPath}/index.jsp" class="text-white"><i class="fa fa-cogs" aria-hidden="true"></i></a> Control de clientes</h1>
            </div>
        </div>
    </div>
</header>