package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */

// Agregamos la notacion de WebServlet, puede ser cualquier otro nombre pero con ese path va a responder en el navegador
@WebServlet("/Servlet")
// Hacemos el extends
public class Servlet extends HttpServlet {

    // Sobre escribimos el metodo doPost
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        try
        {
            PrintWriter out = response.getWriter();

            // Procesamos los elementos y recuperamos la informacion del lado del servidor de JAVA
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String tecnologias[] = request.getParameterValues("tecnologia");
            String genero = request.getParameter("genero");
            String ocupacion = request.getParameter("ocupacion");
            String musicas[] = request.getParameterValues("musica");
            String comentarios = request.getParameter("comentarios");

            out.print("Datos enviados desde el formulario a Servlet");
            out.print("<br/>");
            out.print("Usuario: " + usuario);
            out.print("<br/>");
            out.print("Password: " + password);
            out.print("<br/>");
            
            for (String tecnologia : tecnologias)
            {
                out.print(tecnologia);
                out.print(" / ");
            }
            out.print("<br/>");

            out.print("Genero: " + genero);
            out.print("<br/>");
            out.print("Ocupacion: " + ocupacion);
            out.print("<br/>");

            for (String musica : musicas)
            {
                out.print(musica);
                out.print(" / ");
            }
            out.print("<br/>");

            out.print("Comentarios: " + comentarios);
            out.print("<br/>");

            out.print("<a href='/FormulariosHTML/'>Volver atras</a>");

        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
    }

}
