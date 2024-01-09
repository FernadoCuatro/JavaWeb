package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
// Configuramos el nombre del componente desde el url del action
@WebServlet("Servlet")
public class Servlet extends HttpServlet {
    // Procesamos la informacion
    // Como estamos envialos los datos por post, sobre escribimos ese metodo. es decir el doPost
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        // Procesamos los parametros, con los valores proporcionados
        // Leer los parametros del formulario HTML
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        // Mandamos a consola estos valores
        // Se imprime en la consola de GlassFish
        // Esto esta del lado del servidor
        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);
        
        // Escribimos en la salida
        try
        {
            PrintWriter out = response.getWriter();  
            
            // Agregamos HTML, pero no es recomendable
            // Lo hice rapido
            out.println("usuario = " + usuario + "<br/>");
            out.println("password = " + password);
            
            out.close();
            
        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        
        
    }
    
}
