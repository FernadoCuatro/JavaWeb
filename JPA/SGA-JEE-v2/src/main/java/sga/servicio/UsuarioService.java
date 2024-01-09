package sga.servicio;

import java.util.List;
import javax.ejb.Local;
import sga.domain.Usuario;

/**
 *
 * @author Fernando Cuatro
 */
/* Interfaz local */
@Local
public interface UsuarioService {
    public List<Usuario> listarUsuario();
    
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    
    public Usuario encontrarUsuarioPorUsername(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
}
