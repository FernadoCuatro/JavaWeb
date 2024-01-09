package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */

// Para que esto pueda ser un Servlets debe de extender de HttpServlet

// Para reconocerlo y accederlo desde el navegador se agrega la notacion
// El nombre puede ser cualquiera no el nombre de la clase
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
 
 // Sobreescribimos el metodo get
 // Por ejemplo, una petición GET puede redirigirse a un método doGet.
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 {
  // Vamos a recibir la peticion, posteriormente se le respondera al navegador
  // con la cadena de hola mundo
  response.setContentType("text/html;charset=UTF-8");
  
  // Variable de salida
  try
  {
   PrintWriter out = response.getWriter();
   
   // Desntro de los WebServlet no es recomendable utilizar condigo HTML
   out.println("Hola mundo desde WebServlet");
   
   // Al hacer Clean and Build se genera el archivo HolaMundoServlets-1.0.war
   // que war significa: web archive file
   // Es un archivo que contiene informacion web
    
  } catch (IOException e)
  {
   e.printStackTrace(System.out);
  }
  
  
 }
 
 
 
}
