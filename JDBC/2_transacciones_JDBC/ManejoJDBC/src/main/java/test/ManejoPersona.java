package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;

/**
 *
 * @author Fernando Cuatro
 */
public class ManejoPersona {

 public static void main(String[] args) {

  Connection conexion = null;
  try
  {
   conexion = Conexion.getConection();

   // Revisamos si la conexion esta en autocommit ya que por defecto esta en true
   if (conexion.getAutoCommit())
   {
    // No queremos queremos que el commit se haga de manera automatica
    // Ya que se hara de manera automatica
    conexion.setAutoCommit(false);
   }

   // Una transaccion es ejecutar varias sentencias SQL que modifican el estao de la base de datos
   // El select no es muy recomendable tomarlo como transaccion ya que no altera el estado de la base de datos
   PersonaDAO personaDAO = new PersonaDAO(conexion);

   Persona personaEditar = new Persona(1, "Miguel", "Cuatro", "miguelcuatromejia@java.com", "70377081");
   personaDAO.actualizar(personaEditar);

   Persona personaInsertar = new Persona("Fernando Miguel", "Cuatro Rivera", "fernando@java.com", "64220098979700");
   personaDAO.insertar(personaInsertar);

   // Cuando sabemos que todo lo que queremos esta bien, llamamos al metodo commit
   // Hasta este momento se van a guardar los datos
   conexion.commit();
   
  } catch (SQLException e)
  {
   e.printStackTrace(System.out);
   
   // En caso de error imprimimos lo siguente:
   // Entramos en rollbalk
   System.out.println("Entramos en rollbalk");
   
   try
   {
    conexion.rollback();
    
   } catch (SQLException erb)
   {
    erb.printStackTrace(System.out);
   }
   
   
  }
 }
}
