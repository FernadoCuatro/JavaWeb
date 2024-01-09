package sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import sga.domain.Persona;

/**
 *
 * @author Fernando Cuatro
 */

/* Esta clase debe ser un EJB para que pueda inyectarse el EntityManager de JPA */
/* EJB = Enterprese Java Beans */

/* Imprementa la inteface que ya hemos definido */
@Stateless
public class PersonaDAOImpl implements PersonaDAO {
    /* Inyectamos la unidad de Persistencia */
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Persona> findAllPersonas() {
        /* Usamos el NamedQuery que ya hemos definido */
        /* Nos devolvera objetos Java y no columnas aisladas de la db */
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        /* Tambien podemos crear Querys */
        Query query = em.createQuery("from Persona p where p.email =: email");
        query.setParameter("email", persona.getEmail());
        
        /* Solo nos devuelve un valor */
        /* Devolvemos un dato de tipo Persona */
        return (Persona)query.getSingleResult();
    }

    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        /* merge se encarga de revisar si hay cambios y sincronizarlos */
        em.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        /* Devemos hacer un merge y despues remover el objeto */
        em.remove(em.merge(persona));
    }
}
