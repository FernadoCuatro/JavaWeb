package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        String accion = request.getParameter("accion");
        
        
        // 2. Creamos los JavaBeans
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 4);
        Rectangulo recplicacion = new Rectangulo(5, 6);
        
        // 3. Agregamos el JavaBean a algun alcance y lo compartimos
        // Request, Session, Application
        
        // Revisamos la accion proporcionada
        if ("agregaVariables".equals(accion))
        {
            // Alcance request
            request.setAttribute("rectanguloRequest", recRequest); 
            // El ultimo es la referencia a la variable linea 24
            // El primero es el que compartimos para accederlo desde otro archivo
            
            // Alcance sesion
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion", recSession);
            
            // Alcance application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloAplicacion", recplicacion);
            
            // Agregamos el mensaje, para saber que fue lo que se ejecuto
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            // 4. Redirreccionamos al jsp que despliega la variables
            try
            {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (IOException | ServletException e)
            {
                e.printStackTrace(System.out);
            }
            
        } else if("listarVariables".equals(accion)) {
            // 4. Redirreccionamos al jsp que despliega la variables
            try
            {
                request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
            } catch (IOException | ServletException e)
            {
                e.printStackTrace(System.out);
            }
            
        } else {
            // Caso sin parametros
            // 4. Redirreccionamos al jsp a la pagina de inicio
            try
            {
                request.setAttribute("mensaje", "Accion no proporcionada o desconocida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
                // Para redireccionar pero sin compartir o propagar informarcion con el forward
                // Se hace asi:
                // response.sendRedirect("index.jsp");
            } catch (IOException | ServletException e)
            {
                e.printStackTrace(System.out);
            }
        }
        
    }
}
