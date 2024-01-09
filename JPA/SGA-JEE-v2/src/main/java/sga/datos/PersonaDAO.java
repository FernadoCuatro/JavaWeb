package sga.datos;

import java.util.List;
import sga.domain.Persona;

/**
 *
 * @author Fernando Cuatro
 */

/* Representa la capa logica de la capa de datos */
public interface PersonaDAO {
    /* Listar todas las personas */
    public List<Persona> findAllPersonas();
    
    /* Buscamos una persona por ID, obtenemos solo una perona */
    public Persona findPersonaById(Persona persona);
    
    /* Ahora, buscamos por Email */
    public Persona findPersonaByEmail(Persona persona);
    
    /* Para insertar */
    public void insertPersona(Persona persona);
    
    /* Para actualizar */
    public void updatePersona(Persona persona);
    
    /* Para eliminar una persona */
    public void deletePersona(Persona persona);
}
