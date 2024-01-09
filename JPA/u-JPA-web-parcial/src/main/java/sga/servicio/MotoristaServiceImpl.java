package sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sga.domain.Motorista;
import sga.datos.MotoristaDAO;

@Stateless
public class MotoristaServiceImpl implements MotoristaServiceRemote, MotoristaService{

    /* Accedemos a la interface, Motorista DAO */
    /* Inyectamos este objeto con CDI */
    @Inject
    private MotoristaDAO estudinteDAO;
    
    @Override
    public List<Motorista> listarMotorista() {
        return estudinteDAO.findAllMotorista();
    }

    @Override
    public Motorista encontrarMotoristaPorId(Motorista motorista) {
        return estudinteDAO.findMotoristaById(motorista);
    }

    @Override
    public Motorista encontrarMotoristaPorDui(Motorista motorista) {
        return estudinteDAO.findMotoristaByDui(motorista);
    }

    @Override
    public void registrarMotorista(Motorista motorista) {
        estudinteDAO.insertMotorista(motorista);
    }

    @Override
    public void modificarMotorista(Motorista motorista) {
        estudinteDAO.updateMotorista(motorista);
    }

    @Override
    public void eliminarMotorista(Motorista motorista) {
        estudinteDAO.deleteMotorista(motorista);
    }
    
}
