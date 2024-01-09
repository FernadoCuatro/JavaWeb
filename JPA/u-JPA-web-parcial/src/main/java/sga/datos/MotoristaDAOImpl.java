package sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import sga.domain.Motorista;

/**
 *
 * @author Fernando Cuatro
 */

/* Esta clase debe ser un EJB para que pueda inyectarse el EntityManager de JPA */
/* EJB = Enterprese Java Beans */

/* Imprementa la inteface que ya hemos definido */
@Stateless
public class MotoristaDAOImpl implements MotoristaDAO {
    /* Inyectamos la unidad de Persistencia */
    @PersistenceContext(unitName = "MotoristaPU")
    EntityManager em;

    @Override
    public List<Motorista> findAllMotorista() {
        /* Usamos el NamedQuery que ya hemos definido */
        /* Nos devolvera objetos Java y no columnas aisladas de la db */
        return em.createNamedQuery("Motorista.findAll").getResultList();
    }

    @Override
    public Motorista findMotoristaById(Motorista motorista) {
        return em.find(Motorista.class, motorista.getIdMotorista());
    }

    @Override
    public Motorista findMotoristaByDui(Motorista motorista) {
        /* Tambien podemos crear Querys */
        Query query = em.createQuery("from Motorista m where m.diuMotorista =: dui");
        query.setParameter("dui", motorista.getDiuMotorista());
        
        /* Solo nos devuelve un valor */
        /* Devolvemos un dato de tipo Motorista */
        return (Motorista)query.getSingleResult();
    }

    @Override
    public void insertMotorista(Motorista motorista) {
        em.persist(motorista);
    }

    @Override
    public void updateMotorista(Motorista motorista) {
        /* merge se encarga de revisar si hay cambios y sincronizarlos */
        em.merge(motorista);
    }

    @Override
    public void deleteMotorista(Motorista motorista) {
        /* Devemos hacer un merge y despues remover el objeto */
        em.remove(em.merge(motorista));
    }
}
