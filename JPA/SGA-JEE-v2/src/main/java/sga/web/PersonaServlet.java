package sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import sga.domain.Persona;
import sga.servicio.PersonaService;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    /* Inyeccion del componente local por medio de la interface local */
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Lo que se hara, es que consumira las personas por medio de la instancia local */
        /* De esta forma accedemos al EJB de forma local */
        List<Persona> personas = personaService.listarPersonas();
        
        System.out.println("Personas: " + personas);
        
        /* Colocamos la persona en un alcance */
        request.setAttribute("personas", personas);
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
    
}
