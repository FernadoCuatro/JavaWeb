package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Fernando Cuatro
 */
public class PersonaDAO {
 // Domain Access Object > DAO
 // Objeto de acceso de dominio
 // Es como la clase donde se hace el crud

 // Es recomendable definir las sentencias siempre al inicio
 private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
 private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES (?,?,?,?)";
 private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona=?";
 private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";
 
 // Definimos el metodo que retornara objeto de tipo personas
 public List<Persona> seleccionar() {
  Connection conn = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;
  Persona persona = null;
  List<Persona> personas = new ArrayList<>();

  try
  {
   // Conectamos a la base de datos
   conn = Conexion.getConection();
   stmt = conn.prepareStatement(SQL_SELECT);
   rs = stmt.executeQuery();

   while (rs.next())
   {
    // Cada persona se convierte en un objeto de tipo persona
    persona = new Persona(rs.getInt("id_persona"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("telefono"));
    personas.add(persona);
   }

  } catch (SQLException e)
  {
   e.printStackTrace(System.out);
  } finally
  {
   try
   {
    Conexion.close(rs);
    Conexion.close(stmt);
    Conexion.close(conn);
   } catch (SQLException e)
   {
    e.printStackTrace(System.out);
   }
  }

  return personas;
 }
 
 // Metodo para listar las personas
 public void listarPersonas(){
    List<Persona> personas = seleccionar();

  //  for (Persona persona: personas)
  //  {
  //   System.out.println("persona = " + persona);
  //  }
  // Funcion landa con el forEach
  personas.forEach(persona ->
  {
   System.out.println("persona = " + persona);
  });
 }
 
 // Metodo de insertar
 // Regresara un entero para decirnos cuantos registros fueron afectados
 public int insertar(Persona persona)
 {
  Connection conn = null;
  PreparedStatement stmt = null;
  int registro = 0;
  
  try
  {
   conn = Conexion.getConection();
   stmt = conn.prepareStatement(SQL_INSERT);
   stmt.setString(1, persona.getNombre());
   stmt.setString(2, persona.getApellido());
   stmt.setString(3, persona.getEmail());
   stmt.setString(4, persona.getTelefono());
   
   // Tiene que mandarnos lo que afecto en la base de datos
   // executeUpdate() se usa para todos menos la del select
   registro = stmt.executeUpdate();
   
  } catch (SQLException e)
  {
   e.printStackTrace(System.out);
  } 
  finally {
   try
   {
    Conexion.close(stmt);
    Conexion.close(conn);
   } catch (SQLException e)
   {
    e.printStackTrace(System.out);
   }

  }
  
  return registro;
 }

 // Metodo de actualizar datos de una persona
 public int actualizar(Persona persona)
 {
  Connection conn = null;
  PreparedStatement stmt = null;
  int registro = 0;
  
  try
  {
   conn = Conexion.getConection();
   stmt = conn.prepareStatement(SQL_UPDATE);
   stmt.setString(1, persona.getNombre());
   stmt.setString(2, persona.getApellido());
   stmt.setString(3, persona.getEmail());
   stmt.setString(4, persona.getTelefono());
   stmt.setInt(5, persona.getIdPersona());
   
   // Tiene que mandarnos lo que afecto en la base de datos
   // executeUpdate() se usa para todos menos la del select
   registro = stmt.executeUpdate();
   
  } catch (SQLException e)
  {
   e.printStackTrace(System.out);
  } 
  finally {
   try
   {
    Conexion.close(stmt);
    Conexion.close(conn);
   } catch (SQLException e)
   {
    e.printStackTrace(System.out);
   }

  }
  
  return registro;
 }
 
 // Metodo para suprimir una persona
 public int eliminar(Persona persona)
 {
  Connection conn = null;
  PreparedStatement stmt = null;
  int registro = 0;
  
  try
  {
   conn = Conexion.getConection();
   stmt = conn.prepareStatement(SQL_DELETE);
   stmt.setInt(1, persona.getIdPersona());
   
   // Tiene que mandarnos lo que afecto en la base de datos
   // executeUpdate() se usa para todos menos la del select
   registro = stmt.executeUpdate();
   
  } catch (SQLException e)
  {
   e.printStackTrace(System.out);
  } 
  finally {
   try
   {
    Conexion.close(stmt);
    Conexion.close(conn);
   } catch (SQLException e)
   {
    e.printStackTrace(System.out);
   }

  }
  
  return registro;
 }
}
