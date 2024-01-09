package sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sga.datos.PersonaDAO;
import sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{

    /* Accedemos a la interface, Persona DAO */
    /* Inyectamos este objeto con CDI */
    @Inject
    private PersonaDAO personaDAO;
    
    @Override
    public List<Persona> listarPersonas() {
        return personaDAO.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDAO.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDAO.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDAO.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        personaDAO.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDAO.deletePersona(persona);
    }
    
}
