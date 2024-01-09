package sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import sga.domain.Motorista;

@Remote
public interface MotoristaServiceRemote {
    
    public List<Motorista> listarMotorista();
    
    public Motorista encontrarMotoristaPorId(Motorista motorista);
    
    public Motorista encontrarMotoristaPorDui(Motorista motorista);
    
    public void registrarMotorista(Motorista motorista);
    
    public void modificarMotorista(Motorista motorista);
    
    public void eliminarMotorista(Motorista motorista);
    
}
