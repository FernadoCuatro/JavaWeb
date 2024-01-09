package sga.servicio;

import java.util.List;
import javax.ejb.Local;
import sga.domain.Estudiante;

/**
 *
 * @author Fernando Cuatro
 */
/* Interfaz local */
@Local
public interface EstudianteService {
    public List<Estudiante> listarEstudiantes();
    
    public Estudiante encontrarEstudiantePorId(Estudiante estudiante);
    
    public Estudiante encontrarEstudiantePorApellido(Estudiante estudiante);
    
    public void registrarEstudiante(Estudiante estudiante);
    
    public void modificarEstudiante(Estudiante estudiante);
    
    public void eliminarEstudiante(Estudiante estudiante);
}
