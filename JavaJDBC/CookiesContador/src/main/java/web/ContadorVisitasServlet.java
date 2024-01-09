package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        // Declaramos una variable contador
        int contador = 0;
        
        // Revisar si existe la cookie contadorVIsitas
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null)
        {
            // Recorriendo el arreglo de cookies
            for (Cookie e: cookies)
            {
                if (e.getName().equals("contadorVisitas"))
                {
                    // Si eexiste obtenemos el valor el valor y lo asignamos a la variable contador
                    contador = Integer.parseInt(e.getValue());
                }
            }
        }
        
        // Incrementando el contador en uno
        contador ++;
        
        // Agregar este valor a la respuesta del navegador
        // Es decir creamos la cookie por primera vez o se sobreescribe 
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
        
        // Definimos un tiempo de 1 hora a la cookie (3600 segundos)
        c.setMaxAge(3600);
        
        // Agregamos esta cookie con el response
        response.addCookie(c);
        
        // Mandamos la respuesta al navegador
        response.setContentType("text/html;charset=UTF-8");
        
        try
        {
            PrintWriter out = response.getWriter();
            
            out.print("Contador de visitas <br/>");
            out.print("<p>Sus visitas en este sitio son: <span style='font-size: 4.0em'>" + contador + "</span></p>");
            out.close();
            
        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        
    }
}
