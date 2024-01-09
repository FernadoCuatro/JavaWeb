package sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import sga.domain.Estudiante;

@Remote
public interface EstudianteServiceRemote {
    
    public List<Estudiante> listarEstudiantes();
    
    public Estudiante encontrarEstudiantePorId(Estudiante persona);
    
    public Estudiante encontrarEstudiantePorApellido(Estudiante persona);
    
    public void registrarEstudiante(Estudiante persona);
    
    public void modificarEstudiante(Estudiante persona);
    
    public void eliminarEstudiante(Estudiante persona);
    
}
