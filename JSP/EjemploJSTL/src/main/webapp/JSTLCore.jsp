<%-- 
    Document   : JSTLCore
    Created on : 12 sept. 2022, 14:06:45
    Author     : Fernando Cuatro
--%>

<%-- Importamos el tag lib que es necesario, en este caso core --%>
<%-- Con esta directiva --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core (Jsp Standard Tag Library)</h1>
        
        <%-- Manipulacion de variables --%>
        <%-- Definicion de una variable de tipo string --%>
        <c:set var="nombre" value="Fernando" />
        
        <%-- Imprimimos --%>
        <p>Nombre: <c:out value="${nombre}" /></p> 
        
        <%-- Variable con codigo HTML --%>
        <p>Variable con codigo HTML: <c:out value="<h4>Hola, desde un H4</h4>" /></p>
        <c:out value="<h4>Hola, desde un H4</h4>" escapeXml="false" />
        
        <%-- Condicionado, uso de if --%>
        <c:set var="bandera" value="true" />
        <c:if test="${bandera}">
            <p>La bandera es ${bandera} </p>
        </c:if>
        
        <%-- Condicionado, uso de switch  --%>
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    <p>Opcion 1, seleccionada</p>
                </c:when>
                    
                <c:when test="${param.opcion == 2}">
                    <p>Opcion 2, seleccionada</p>
                </c:when>    
                   
                <c:otherwise>
                    <p>La opcion no es valida: ${param.opcion} </p>
                </c:otherwise>
            </c:choose>
        </c:if>
        
        <%-- Iteracion de un arreglo --%>
        <% 
            String nombres[] = {"Melissa", "Alexandra", "Fernando", "Cuatro"};
            request.setAttribute("nombres", nombres); 
            // El ultimo es el nombre de la variable, el primero es como quiere accederlo
            // desde otro elemento, es decir es el alcance
        %>
        <h1>Lista de nombres:</h1>
        <ul>
            <%-- EL buscara el alcancen en este orden --%>
            <%-- >> Page, Request, Session, Application (En la primera que encuentre) --%>
            <c:forEach var="persona" items="${nombres}">
                <li>Nombre: ${persona}</li>
            </c:forEach>
        </ul>
        
        <a href="index.jsp">Volver al inicio</a>
        
    </body>
</html>
