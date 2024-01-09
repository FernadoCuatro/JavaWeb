package datos;

import java.sql.*;

/**
 *
 * @author Fernando Cuatro
 */
public class Conexion {

 // Una variable constante
 // Escribir la cadena de conexion
 private static final String JDBC_URL = "jdbc:mysql://localhost/javaweb_db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
 private static final String JDBC_USER = "root";
 private static final String JDBC_PASSWORD = "";

 // Metodo de conexion
 public static Connection getConection() throws SQLException {
  return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
 }

 // Cierre de conexiones
 public static void close(ResultSet rs) throws SQLException {
  rs.close();
 }

 public static void close(Statement smtm) throws SQLException {
  smtm.close();
 }

 public static void close(PreparedStatement smtm) throws SQLException {
  smtm.close();
 }
 
 public static void close(Connection conexion) throws SQLException {
  conexion.close();
 }

}
