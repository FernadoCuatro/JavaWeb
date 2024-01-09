package datos;

import domain.PersonaDTO;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Fernando Cuatro
 */
public interface PersonaDAO {

 // Esta interface es para definir los metodos que vamos a utilizar
 // Ajustamos de una vez que estos metodos lanzaran una excepcion de tipo SQLException
 public List<PersonaDTO> seleccionar();

 public int insertar(PersonaDTO persona) throws SQLException;

 public int actualizar(PersonaDTO persona) throws SQLException;

 public int eliminar(PersonaDTO persona) throws SQLException;
 
}
