package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=UTF-8");
        
        // Procesamos el nuevo articulo que nos estan enviando por medio del metodo post
        String articuloNuevo = request.getParameter("articulo");
        
        // Creamos o recuperamos el objeto http session
        HttpSession sesion = request.getSession();
        
        // Recuperamos la lista de articulos agregados si existe
        List<String> articulos = (List<String>)sesion.getAttribute("articulos");
        
        // Verificamos si la lista de artiulos existe
        if (articulos == null)
        {
            // No hay nada en el carrito de compras
            articulos = new ArrayList<>();
            
            // Agregamos la lista a la sesion
            sesion.setAttribute("articulos", articulos);
        }
        
        // Revisamos y agregamos el nuevo articulo
        
        // Si no es nulo y si no viene vacio se agrega al carrito
        if (articuloNuevo != null && !articuloNuevo.trim().equals(""))
        {
            articulos.add(articuloNuevo);
        }
        
        
        // Imrpimimos la lista de articulos
        try
        {
            PrintWriter out = response.getWriter();
            out.print("<h1>Lista de Articulos</h1>");
            out.print("<br/>");
            
            // Iteramos todos los articulos desde la lista
            for (String articulo: articulos)
            {
                out.print("<li>" + articulo + "</li>");
            }
            
            out.print("<br/>");
            
            // Regresar al inicio
            out.print("<a href='/EjemploCarritoCompras'>Volver al inicio</a>");
            
            out.close();
            
        } catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        
        
        
        
    }
}
