<%-- 
    Document   : getter
    Created on : 12 sept. 2022, 10:09:22
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leer Java Beans</title>
    </head>
    <body>
        <h1>Leer Java Beans</h1>
        
        <%-- Utilizamsos una accion, para leer la informacion --%>
        <%-- La variable en el id es el mismo del setter, si existe lo recupera, si no lo crea --%>
        <%-- El scope se recomienda que sea el mismo --%>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        
        <p>Valor base: <jsp:getProperty name="rectangulo" property="base" /> </p>
        <p>Valor altura: <jsp:getProperty name="rectangulo" property="altura" /></p>
        
        <%-- No se manda a llamar con el get, solamente el area, el reconoce auticamente el get para no escribirlo completo --%>
        <h3>Valor del area: <jsp:getProperty name="rectangulo" property="area" /> </h3>
        
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
