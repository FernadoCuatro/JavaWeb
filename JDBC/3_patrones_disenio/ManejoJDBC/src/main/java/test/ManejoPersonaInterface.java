package test;

import datos.Conexion;
import datos.PersonaDAO;
import datos.PersonaDAOJDBC;
import domain.PersonaDTO;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Fernando Cuatro
 */
public class ManejoPersonaInterface {

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
   
   // Aqui no vamos a usar la clase. Vamos que usar la interface
   // De esta forma ya nos interesa la tecnologia que este usando los datos
   // si no que sera lo mas generica posible
   // De lado izquiero manejamos el tipo de interface
   PersonaDAO personaDAO = new PersonaDAOJDBC(conexion);

   // Probamos el del select
   // Ya no sabemos la tecnologia que se esta utilizando
   // ctrl + clic -> Nos lleva a la interface y no a la clase en la implementacion
   // Asi se crea la capa de datos
   List<PersonaDTO> personas = personaDAO.seleccionar();

   personas.forEach(persona ->
   {
    System.out.println("PersonaDTO: " + persona);
   });

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
