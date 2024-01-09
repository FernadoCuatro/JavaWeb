<%-- 
    Document   : index
    Created on : 11 sept. 2022, 20:03:33
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inclusion Dinamica</title>
    </head>
    <body>
        <%-- Inclusion dinamica, solo se pueden con jsp --%>
        <%-- Se generan servlet para cada uno de los jsp --%>
        <h1>Inclusion Dinamica</h1>
        
        <%-- se usa la accion:  --%>
        <jsp:include page="paginas/recursoPublico.jsp" /> <%-- Recurso publico --%>
        
        <%-- Como se hace una sola pagina por asi decirlo de todos los elementos, el bgcolor de --%>
        <%-- La pagina privada se afectara a toda la pagina, incluso esta --%>
        <%-- Es decir, como que se convinan jajaj --%>
        <%-- En la salida aparecen dos estructuras html al ver el codigo fuente  --%>
        
        <%-- Tambien enviamos parametros --%>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="color_fondo" value="#1ce551" />
        </jsp:include> <%-- Recurso privado --%>
        
    </body>
</html>
