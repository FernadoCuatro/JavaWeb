package sga.datos;

import java.util.List;
import sga.domain.Motorista;

/**
 *
 * @author Fernando Cuatro
 */

/* Representa la capa logica de la capa de datos */
public interface MotoristaDAO {
    /* Listar todas las personas */
    public List<Motorista> findAllMotorista();
    
    /* Buscamos una persona por ID, obtenemos solo una perona */
    public Motorista findMotoristaById(Motorista motorista);
    
    /* Ahora, buscamos por Email */
    public Motorista findMotoristaByDui(Motorista motorista);
    
    /* Para insertar */
    public void insertMotorista(Motorista motorista);
    
    /* Para actualizar */
    public void updateMotorista(Motorista motorista);
    
    /* Para eliminar una persona */
    public void deleteMotorista(Motorista motorista);
}
