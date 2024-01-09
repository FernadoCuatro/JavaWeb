<!-- Directiva para manejar los errores no controlados. Mas o menos como una pagina 404 xd -->
<!-- Todos los recuros que estan dentro de web pages > WEB-INF son privados, es decir no son accesibles desde el navegador -->
<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>

<!-- Esta es una directiva, para importar la clase definida -->
<!-- Para separar clases, se hace por comas -->
<%@page import="utilerias.Conversiones, java.util.Date"  %>

<!-- Directiva para indicar el tipo de contenido, en este caso es un excel -->
<%@page contentType="application/vnd.ms-excel" %>

<!-- Indicamos el nombre del archivo que vamos a generar con un ScriptLet -->
<% 
    String nombreArchivo = "reporte.xls";
    // Con attachment no se puede redirigir a una pagina de error, se escribe inline
    response.setHeader("Content-Disposition", "inline; filename=" + nombreArchivo);
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Reporte Excel</title>
    </head>
    <body>
        <h1>Reporte Excel</h1>
        
        <table border="1">
            
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis basica de Java</td>
                <td><%= Conversiones.format("500") %></td>
            </tr>
            <tr>
                <td>2. Programacion con Java</td>
                <td>Pondremos en practica, conceptos de POO</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
            
        </table>
        
    </body>
</html>
