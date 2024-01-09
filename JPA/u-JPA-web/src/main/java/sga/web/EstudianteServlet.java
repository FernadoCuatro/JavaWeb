package sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import sga.domain.Estudiante;
import sga.servicio.EstudianteService;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/estudiantes")
public class EstudianteServlet extends HttpServlet {
    /* Inyeccion del componente local por medio de la interface local */
    @Inject
    EstudianteService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Lo que se hara, es que consumira las personas por medio de la instancia local */
        /* De esta forma accedemos al EJB de forma local */
        List<Estudiante> personas = personaService.listarEstudiantes();
        
        System.out.println("Estudiantes: " + personas);
        
        /* Colocamos la persona en un alcance */
        request.setAttribute("estudiantes", personas);
        request.getRequestDispatcher("/listadoEstudiante.jsp").forward(request, response);
    }
    
}
