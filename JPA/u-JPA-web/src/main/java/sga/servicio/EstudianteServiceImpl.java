package sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sga.domain.Estudiante;
import sga.datos.EstudianteDAO;

@Stateless
public class EstudianteServiceImpl implements EstudianteServiceRemote, EstudianteService{

    /* Accedemos a la interface, Estudiante DAO */
    /* Inyectamos este objeto con CDI */
    @Inject
    private EstudianteDAO estudinteDAO;
    
    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudinteDAO.findAllEstudiante();
    }

    @Override
    public Estudiante encontrarEstudiantePorId(Estudiante estudiante) {
        return estudinteDAO.findEstudianteById(estudiante);
    }

    @Override
    public Estudiante encontrarEstudiantePorApellido(Estudiante estudiante) {
        return estudinteDAO.findEstudianteByApellido(estudiante);
    }

    @Override
    public void registrarEstudiante(Estudiante estudiante) {
        estudinteDAO.insertEstudiante(estudiante);
    }

    @Override
    public void modificarEstudiante(Estudiante estudiante) {
        estudinteDAO.updateEstudiante(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        estudinteDAO.deleteEstudiante(estudiante);
    }
    
}
