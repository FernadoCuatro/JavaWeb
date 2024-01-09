package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        // Decirle que vamos a refrescar la informacion cada segundo
        response.setContentType("text/html;charset=UTF-8");
        
        // Le decimos que la informacion que enviara se actualizara cada segundo
        response.setHeader("refresh", "1");
        
        // Obtenemos la fecha actual
        Date fecha = new Date();
        // FOrmato a la fecha
        SimpleDateFormat formateador = new SimpleDateFormat("'Hora actualizada' HH:mm:ss");
        
        String horaConFormato = formateador.format(fecha);
        
        // Salida para el usuario
        try
        {
            PrintWriter out = response.getWriter();
            
            out.print("<h1>" + horaConFormato + "</h1>");
            out.close();
            
        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
    
    }

}
