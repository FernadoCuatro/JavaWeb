package sga.datos;

import java.util.List;
import sga.domain.Usuario;

/**
 *
 * @author Fernando Cuatro
 */

/* Representa la capa logica de la capa de datos */
public interface UsuarioDAO {
    /* Listar todas las usuario */
    public List<Usuario> findAllUsuarios();
    
    /* Buscamos una usuario por ID, obtenemos solo una usuario */
    public Usuario findUsuarioById(Usuario usuario);
    
    /* Ahora, buscamos por Email */
    public Usuario findUsuarioByUsername(Usuario usuario);
    
    /* Para insertar */
    public void insertUsuario(Usuario usuario);
    
    /* Para actualizar */
    public void updateUsuario(Usuario usuario);
    
    /* Para eliminar una usuario */
    public void deleteUsuario(Usuario usuario);
}
