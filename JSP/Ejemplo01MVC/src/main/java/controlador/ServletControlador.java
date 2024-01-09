package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        // 1. Procesamos los parametros, si existen.
        
        // 2. Creamos los JavaBeans
        Rectangulo rectangulo = new Rectangulo(3, 6);
        
        // 3. Agregamos el JavaBean a algun alcance y lo compartimos
        // Request, Session, Application
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rectangulo);
        /* El primer atributo es el que obtenemos para todo */
        /* El segundo es el nombre de la linea 22 */
        
        // 4. Redirrecionamos a la vista seleccionada y compartimos la informacion
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        try
        {
            rd.forward(request, response);
        } catch (IOException | ServletException e)
        {
            e.printStackTrace(System.out);
        }
        
    }
}
