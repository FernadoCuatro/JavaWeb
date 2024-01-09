package sga.datos;

import java.util.List;
import sga.domain.Estudiante;

/**
 *
 * @author Fernando Cuatro
 */

/* Representa la capa logica de la capa de datos */
public interface EstudianteDAO {
    /* Listar todas las personas */
    public List<Estudiante> findAllEstudiante();
    
    /* Buscamos una persona por ID, obtenemos solo una perona */
    public Estudiante findEstudianteById(Estudiante estudiante);
    
    /* Ahora, buscamos por Email */
    public Estudiante findEstudianteByApellido(Estudiante estudiante);
    
    /* Para insertar */
    public void insertEstudiante(Estudiante estudiante);
    
    /* Para actualizar */
    public void updateEstudiante(Estudiante estudiante);
    
    /* Para eliminar una persona */
    public void deleteEstudiante(Estudiante estudiante);
}
