<%-- 
    Document   : agregarCliente
    Created on : 24 sept. 2022, 13:04:12
    Author     : Fernando Cuatro
--%>

<!-- Modal -->
<div class="modal fade" id="agregarClienteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title" id="exampleModalLabel">Añadir un nuevo cliente</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="text-white">&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" id="nombre" required >
                    </div>
                    
                    <div class="form-group">
                        <label for="apellido">Apellido:</label>
                        <input type="text" class="form-control" name="apellido" id="apellido" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="apellido">Edad:</label>
                        <input type="number" class="form-control" name="edad" id="edad" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="email">Correo electrónico:</label>
                        <input type="email" class="form-control" name="email" id="email" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="telefono">Teléfono:</label>
                        <input type="tel" class="form-control" name="telefono" id="telefono" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="saldo">Saldo:</label>
                        <input type="decimal" class="form-control" name="saldo" id="saldo" required>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-transparent" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Guardar Cliente</button>
                </div>
            </form>

        </div>
    </div>
</div>