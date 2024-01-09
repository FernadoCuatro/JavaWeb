package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        // Indicamos el tipo de respuesta al navegador
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        
        // Para un uso mas profesional de excel puede usar poi.apache.or
        
        // Indicamos al navegador que no guarde cache
        // Limpiamos la cache del navegador y que no guarde
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        // La que se guarde expire de manera inmediata
        response.setDateHeader("expires", -1);
        
        // Desplegamos la informacion al cliente
        try
        {
           PrintWriter out = response.getWriter(); 
           
           // Escribimos en el excel
           out.println("\tValores");
           out.println("\t1");
           out.println("\t2");
           out.println("\t3");
           out.println("\t4");
           out.println("\t5");
           out.println("Total\t=SUMA(B2:B6)");
        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        
    }
}
