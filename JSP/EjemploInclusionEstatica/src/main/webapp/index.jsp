<%-- 
    Document   : index
    Created on : 11 sept. 2022, 18:45:37
    Author     : Fernando Cuatro
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Estatica</title>
    </head>
    <body>
        <h1>Ejemplo inclusion estatica</h1>

        <%-- Se incluiran dos archivos html, pero pueden ser jsp --%>
        <%-- Con inclucion estatica --%>
        <%-- Con este metodo se hace solamente un solo servlet --%>
        <%-- Incluye las dos paginas incluidas  --%>
        <ul>
            <li><%@include file="paginas/noticias01.html" %></li>
            <li><%@include file="paginas/noticias02.jsp" %></li>
        </ul>
        
    </body>
</html>
