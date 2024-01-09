package test;

import java.sql.*;

/**
 *
 * @author Fernando Cuatro
 */
public class TestJDBC {

 public static void main(String[] args) { //  psvm + tab 
  // Escribir la cadena de conexion
  String url = "jdbc:mysql://localhost/javaweb_db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

  // Ya no es requerido pero se usa bastante
  try
  {
   // Class.forName("com.mysql.cj.jdbc.Driver"); 
   // Ya no es requerida porque en las ultimas versiones, pero en web se puede usar

   // Linea de conexion con los argumentos de la url, con el usuario y las passwor
   Connection conexion = DriverManager.getConnection(url, "root", "");

   // Creamos un objeto para ejecutar sentencias
   Statement instruccion = conexion.createStatement();

   var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";

   // Ejecutamos la instruccion de la sentencia
   // Utilizamos el tipo interface ResultSet
   ResultSet resultado = instruccion.executeQuery(sql);

   // Ejecutamos el resultado
   while (resultado.next())
   {
    System.out.println("ID: " + resultado.getInt("id_persona"));
    System.out.println("Nombre completo: " + resultado.getString("nombre") + " " + resultado.getString("apellido"));
    System.out.println("Email: " + resultado.getString("email"));
    System.out.println("Email: " + resultado.getString("telefono") + "\n");
   }
   
   // Cerramos los objetos que hemos trabajado
   resultado.close();
   instruccion.close();
   conexion.close();

  } catch (SQLException e)
  {
   e.printStackTrace(System.out);
  }

 }

}
