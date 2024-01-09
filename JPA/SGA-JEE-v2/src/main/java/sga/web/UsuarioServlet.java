package sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import sga.domain.Usuario;
import sga.servicio.UsuarioService;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    /* Inyeccion del componente local por medio de la interface local */
    @Inject
    UsuarioService usuarioService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Lo que se hara, es que consumira las personas por medio de la instancia local */
        /* De esta forma accedemos al EJB de forma local */
        List<Usuario> usuarios = usuarioService.listarUsuario();
        
        System.out.println("Usuarios: " + usuarios);
        
        /* Colocamos la persona en un alcance */
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);
    }
    
}
