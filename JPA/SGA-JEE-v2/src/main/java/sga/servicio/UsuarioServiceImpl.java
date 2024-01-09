package sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sga.datos.UsuarioDAO;
import sga.domain.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{

    /* Accedemos a la interface, Persona DAO */
    /* Inyectamos este objeto con CDI */
    @Inject
    private UsuarioDAO usuarioDAO;
    
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioDAO.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDAO.findUsuarioById(usuario);
    }

    @Override
    public Usuario encontrarUsuarioPorUsername(Usuario usuario) {
        return usuarioDAO.findUsuarioByUsername(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDAO.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.deleteUsuario(usuario);
    }
    
}
