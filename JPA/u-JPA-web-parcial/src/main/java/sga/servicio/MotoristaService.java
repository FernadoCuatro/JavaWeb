package sga.servicio;

import java.util.List;
import javax.ejb.Local;
import sga.domain.Motorista;

/**
 *
 * @author Fernando Cuatro
 */
/* Interfaz local */
@Local
public interface MotoristaService {
    public List<Motorista> listarMotorista();
    
    public Motorista encontrarMotoristaPorId(Motorista motorista);
    
    public Motorista encontrarMotoristaPorDui(Motorista motorista);
    
    public void registrarMotorista(Motorista motorista);
    
    public void modificarMotorista(Motorista motorista);
    
    public void eliminarMotorista(Motorista motorista);
}
