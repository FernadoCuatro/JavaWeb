package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        // Suponemos que el usuario esta por primera vez en nuestro sitio
        boolean nuevoUsuario = true;
        
        // Obtener el arreglo de cookies
        // Contiene un nombre y un valor asociado
        Cookie[] cookies = request.getCookies();
        
        // Buscamos si existe alguna cookie creada con anterioridad
        // llamada visitanteRecurrente
        if (cookies != null)
        {
            for (Cookie c: cookies)
            {
                if (c.getName().equals("visitanteRecurrente") && c.getValue().equals("si"))
                {
                    // Si ya existe la cookie es qu ya es un usuario recorrecte
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        String mensaje = null;
        // Si es un nuevo usuario creamos una nueva cookie, con el nombre y el value
        if (nuevoUsuario)
        {
            Cookie visitanteRecurrente = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteRecurrente);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        } else {
            mensaje = "Volviste nuevamente, ¡muchas gracias!";
        }
        
        // Establecemos la respuesta al usuario
        response.setContentType("text/html;charset=UTF-8");
        
        try
        {
            PrintWriter out = response.getWriter();
            
            out.print("Mensaje: " + mensaje);
            out.close();
            
        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
                
    }
    
}
