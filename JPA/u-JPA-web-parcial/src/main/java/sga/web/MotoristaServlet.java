package sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import sga.domain.Motorista;
import sga.servicio.MotoristaService;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/motoristas")
public class MotoristaServlet extends HttpServlet {
    /* Inyeccion del componente local por medio de la interface local */
    @Inject
    MotoristaService motoristaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Lo que se hara, es que consumira las personas por medio de la instancia local */
        /* De esta forma accedemos al EJB de forma local */
        List<Motorista> motoristas = motoristaService.listarMotorista();
        
        /* Colocamos la persona en un alcance */
        request.setAttribute("motoristas", motoristas);
        request.getRequestDispatcher("/listadoMotorista.jsp").forward(request, response);
    }
    
}
