package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=UTF-8");
        
        // Si ya existe el objeto sesion dejara el que esta creado previamente
        // Si no, lo creara de manera automatica
        HttpSession sesion = request.getSession();
        
        String titulo = null;
        
        // Pedir el atributo contadorvisita a la sesion
        Integer contadorVisitas = (Integer)sesion.getAttribute("contadorvisita");
        
        // Preguntamos si es nulo, si es nulo es la primera vez que se accede
        if (contadorVisitas == null)
        {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez!";
        }
        else 
        {
            contadorVisitas++;
            titulo = "¿Veniste otra vez? Muchas gracias por regresar.";
        }
        
        // Agregamos el nuevo valor a la sesion
        sesion.setAttribute("contadorvisita", contadorVisitas);
        
        // Mandamos la respuesta al cliente
        try
        {
            PrintWriter out = response.getWriter();
            out.print(titulo);
            out.print("<br/>");
            out.print("Numeros de acceso al recurso: " + contadorVisitas);
            out.print("<br/>");
            // Identificador unico y se asigna automaticamente
            out.print("ID de la sesion: " + sesion.getId());
            out.close();
            
        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        
        
    }
}
