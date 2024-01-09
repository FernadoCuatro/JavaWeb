<%-- 
    Document   : index
    Created on : 2 sept. 2022, 20:22:25
    Author     : Fernando Cuatro
--%>

<%-- Concepto / agregamos una una declaracion --%>
<%! 
    // Declaramos una variable con el metodo get
    private String usuario = "Fernando";

    public String getUsuario(){
        return usuario;
    }

    // Declaremoa un contador de visitas
    private int contadorVisitas = 1;
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP declaraciones</title>
    </head>
    <body>
        <h1>JSP declaraciones</h1>
        
        <p>Valor de usuario por medio del atributo: <%= this.usuario %></p>
        <p>Valor del usuario por medio del metodo: <%= this.getUsuario() %> </p>
        
        <p>Contador visitas: <%= this.contadorVisitas++ %> </p>
        
    </body>
</html>
