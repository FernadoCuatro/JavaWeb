package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Fernando Cuatro
 */
public class UsuarioDAO {
 // Es recomendable definir las sentencias siempre al inicio
 private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
 private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES (?,?)";
 private static final String SQL_UPDATE = "UPDATE usuario SET usuario=?, password=? WHERE id_usuario=?";
 private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

 // Obtenemos los datos como objetos
 public List<Usuario> seleccionar() {
  Connection conn = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;
  Usuario usuario = null;
  List<Usuario> usuarios = new ArrayList<>();

  try
  {
   // Conectamos a la base de datos
   conn = Conexion.getConection();
   stmt = conn.prepareStatement(SQL_SELECT);
   rs = stmt.executeQuery();

   while (rs.next())
   {
    // Cada persona se convierte en un objeto de tipo persona
    usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("usuario"), rs.getString("password"));
    usuarios.add(usuario);
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

  return usuarios;
 }
 
 // Listamos a los usuarios usando el metodo de arriba
 public void listarUsuario()
 {
  List<Usuario> usuarios = seleccionar();

  // Funcion landa con el forEach
  usuarios.forEach(usuario ->
  {
   System.out.println("Usuario = " + usuario);
  });
 }
 
 // Metodo para insertar a un usuario
 public int insertar(Usuario usuario)
 {
  Connection conn = null;
  PreparedStatement stmt = null;
  int registro = 0;
  
  try
  {
   conn = Conexion.getConection();
   stmt = conn.prepareStatement(SQL_INSERT);
   stmt.setString(1, usuario.getUsuario());
   stmt.setString(2, usuario.getPassword());
   
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
 
 // Metodo para actualizar a un usuario
 public int actualizar(Usuario usuario)
 {
  Connection conn = null;
  PreparedStatement stmt = null;
  int registro = 0;
  
  try
  {
   conn = Conexion.getConection();
   stmt = conn.prepareStatement(SQL_UPDATE);
   stmt.setString(1, usuario.getUsuario());
   stmt.setString(2, usuario.getPassword());
   stmt.setInt(3, usuario.getIdUsuario());
   
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
 
 public int eliminar(Usuario usuario)
 {
  Connection conn = null;
  PreparedStatement stmt = null;
  int registro = 0;
  
  try
  {
   conn = Conexion.getConection();
   stmt = conn.prepareStatement(SQL_DELETE);
   stmt.setInt(1, usuario.getIdUsuario());
   
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
