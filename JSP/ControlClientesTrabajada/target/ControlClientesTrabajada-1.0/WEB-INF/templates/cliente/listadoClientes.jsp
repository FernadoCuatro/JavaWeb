<%-- 
    Document   : listadoClientes
    Created on : 24 sept. 2022, 11:32:46
    Author     : Fernando Cuatro
--%>

<%-- Usamos la directiva: --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Libreria para dar formato al saldo --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%-- Configuramos la localidad para el formato de moneda --%>
<fmt:setLocale value="en_US" />

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de clientes</h4>
                    </div>

                    <%-- table-striped para que agrege un estilo diferente a cada uno de las filas de las tablas --%>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Cliente</th>
                                <th>Edad</th>
                                <th>Telefono</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            <%-- Iteramos cada elemento de la lista de clientes --%>
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>${cliente.idCliente}</td>
                                    <td>${cliente.nombreCliente} ${cliente.apellidoCliente}</td>
                                    <td>${cliente.edadCliente}</td>
                                    <td>${cliente.telefonoCliente}</td>
                                    <td><fmt:formatNumber value="${cliente.saldoCliente}" type="currency" /></td>
                                    <td><a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}" class="btn btn-info"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <%-- Targetas para los totales --%>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo total</h3>
                        <h4 class="display-4">
                            <%-- Esta variable a sido compartida desde el servlet --%>
                            <fmt:formatNumber value="${saldoTotal}" type="currency" />
                        </h4>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total de clientes</h3>
                        <h4 class="display-4">
                            <%-- Esta variable a sido compartida desde el servlet --%>
                            <i class="fa fa-users" aria-hidden="true"></i> ${totalClientes}
                        </h4>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>