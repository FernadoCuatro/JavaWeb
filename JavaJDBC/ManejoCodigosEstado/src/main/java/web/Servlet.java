package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        // Simular los valores correctos

        // Codigos
        // 200 (ok) -> La respuesta fue correcta, es el codigo por default
        // 204 (Sin contenido) -> El navegador continua desplegando el documento previo
        // 301 (Movido permanentemente) -> El documento solicitado ha cambiado la ubicacion, y posiblemente se indica la nueva ruta, en ese caso el navegador se redirecciona a la nueva pagina de manera automatica
        // 302 (Encontrado) -> EL documento se a movido temporalmente, y el navegador se mueve al nuevo url de manera automatica
        // 401 (Sin autorizacion) -> No se tiene permiso para visualizar el contenido solicitado debido a que se trato de acceder a un recurso protegido con contrasena sin la autorizacion respectiva 
        // 404 (No encontrado) -> El recurso solicitado no se encuentra alojado en el servidor web
        // 500 (Error intereno del servidor) -> El servido lanzo una expecion irrecuperable y por lo tanto no se puede continuar con la peticion 
    }
}
