package sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import sga.domain.Usuario;

/**
 *
 * @author Fernando Cuatro
 */

/* Esta clase debe ser un EJB para que pueda inyectarse el EntityManager de JPA */
/* EJB = Enterprese Java Beans */

/* Imprementa la inteface que ya hemos definido */
@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {
    /* Inyectamos la unidad de Persistencia */
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Usuario> findAllUsuarios() {
        /* Usamos el NamedQuery que ya hemos definido */
        /* Nos devolvera objetos Java y no columnas aisladas de la db */
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public Usuario findUsuarioByUsername(Usuario usuario) {
        /* Solo nos devuelve un valor */
        /* Devolvemos un dato de tipo Persona */
        return (Usuario)em.find(Usuario.class, usuario.getUsername());
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        /* merge se encarga de revisar si hay cambios y sincronizarlos */
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        /* Devemos hacer un merge y despues remover el objeto */
        em.remove(em.merge(usuario));
    }
}
