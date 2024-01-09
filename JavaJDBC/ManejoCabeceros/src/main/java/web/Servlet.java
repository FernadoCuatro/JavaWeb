package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/Servlet")
public class Servlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        try
        {
            PrintWriter out = response.getWriter();
            
            out.print("<h1>Cabeceros de tipo HTTP</h1>");
                
            out.close();
        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        
        
    }
}
