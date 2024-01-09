package sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import sga.domain.Estudiante;

/**
 *
 * @author Fernando Cuatro
 */

/* Esta clase debe ser un EJB para que pueda inyectarse el EntityManager de JPA */
/* EJB = Enterprese Java Beans */

/* Imprementa la inteface que ya hemos definido */
@Stateless
public class EstudianteDAOImpl implements EstudianteDAO {
    /* Inyectamos la unidad de Persistencia */
    @PersistenceContext(unitName = "EstudiantePU")
    EntityManager em;

    @Override
    public List<Estudiante> findAllEstudiante() {
        /* Usamos el NamedQuery que ya hemos definido */
        /* Nos devolvera objetos Java y no columnas aisladas de la db */
        return em.createNamedQuery("Estudiante.findAll").getResultList();
    }

    @Override
    public Estudiante findEstudianteById(Estudiante estudiante) {
        return em.find(Estudiante.class, estudiante.getIdEstudiante());
    }

    @Override
    public Estudiante findEstudianteByApellido(Estudiante estudiante) {
        /* Tambien podemos crear Querys */
        Query query = em.createQuery("from Estudiante e where e.apellido =: apellido");
        query.setParameter("apellido", estudiante.getApellido());
        
        /* Solo nos devuelve un valor */
        /* Devolvemos un dato de tipo Estudiante */
        return (Estudiante)query.getSingleResult();
    }

    @Override
    public void insertEstudiante(Estudiante estudiante) {
        em.persist(estudiante);
    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {
        /* merge se encarga de revisar si hay cambios y sincronizarlos */
        em.merge(estudiante);
    }

    @Override
    public void deleteEstudiante(Estudiante estudiante) {
        /* Devemos hacer un merge y despues remover el objeto */
        em.remove(em.merge(estudiante));
    }
}
