package datos;

import java.sql.*;
// Estos imports se manejan para contronlar el pool de conexiones 
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

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
 // Con el Pool de conexion usamos un metodo mas
 
 // Agregado para el pool de conexiones que se encargara de manejarlo
 public static DataSource getDataSource()
 {
  // ds = data source
  BasicDataSource ds = new BasicDataSource();
  
  // Consiguramos el pool de conexiones
  ds.setUrl(JDBC_URL);
  ds.setUsername(JDBC_USER);
  ds.setPassword(JDBC_PASSWORD);
  
  // definimos el tamaño inicial de pool de conexiones
  ds.setInitialSize(5);
  // Debemos de tener cuidado de cuanto se inicializa. Se debe de empezar con un tamaño pequeño
  // Y dependiendo de la necesidad se ajusta, esto demanda muchos recurso
  
  return ds;
 }
 
 // Ya no usamos Driver manager si no al metodo de arriba
 public static Connection getConection() throws SQLException {
  return getDataSource().getConnection();
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
