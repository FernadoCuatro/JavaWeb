/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Estudiante;
import javax.persistence.*;
import org.apache.logging.log4j.*;

/**
    JPA
    JAVA PERSISTENCE API

    Implementa ORM > Objet Relation Mapping

    Objetos y mapeos de la base de datos

    Entidad relacion desde la base de datos
    Diagrama de clases desde el codigo java

    Se trabaja con objetos Java

    POJOs > Cualquier clase de java puede ser una clase entidad

    Consultas utilizando Objetos Java
 */

/**
 *
 * @author Fernando Cuatro
 */
public class EntidadEstudiante {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        /* Trabajamos con la clase Entity Manager Factory */
        /* Para que podamos abrir el objeto de fabrica de JPA */
        
        /* Al final utilizamos el contrsuctor donde la pasamos el nombre de la unidad de persistencia de xml */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        
        /* Creamos una instancia del objeto EntityManager */
        EntityManager em = emf.createEntityManager();
        
        /* Abirmos una transaccion */
        EntityTransaction tx = em.getTransaction();
        
        /* Inicia la transaccion, ahora podemos trabajar con la base de datos */
        tx.begin();
        
        /* Insertamos un nuevo registro en la base de datos */
        /* No especificamos el ID para la base de datos, ya que es AUTO_INCREMENT */
        Estudiante estudiante_1 = new Estudiante("PW9458456", "Keily Sarai", "Cuatro", 19, "Lourdes");
        
        /* Imprimimos en consola, para esto nos sirve el Log4J */
        /* Como esta el metodo ToString, automaticamente nos deberia de mostrarlo si ID */
        log.debug("Objeto a persistir: " + estudiante_1);
        
        /* Persistimos el objeto en la bd */
        em.persist(estudiante_1);
        
        /* Terminamos la transaccion */
        /* Pero debemos hacer el commit adecuado para que se ejecute */
        /* Asi se guarda en la base de datos */
        tx.commit();
        
        /* Ahora si mostramos con el ID */
        log.debug("Objeto persistido: " + estudiante_1);
        
        /* Cerramos todo */
        em.close();
    }
}
