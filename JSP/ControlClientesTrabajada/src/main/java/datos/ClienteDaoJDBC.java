package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Fernando Cuatro
 */
public class ClienteDaoJDBC {
    private static final String SQL_SELECT = "SELECT * FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(cliente_nombre, cliente_apellido, cliente_edad, cliente_email, cliente_telefono, cliente_saldo) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET cliente_nombre=?,cliente_apellido=?,cliente_edad=?,cliente_email=?,cliente_telefono=?,cliente_saldo=? WHERE cliente_id=?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE cliente_id = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM clientes WHERE cliente_id = ?"; 
    
    /* Metodo para listar */
    public List<Cliente> Listar() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        
        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Cliente> clientes = new ArrayList<>();
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement(SQL_SELECT);

            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                int idCliente = rs.getInt("cliente_id");
                String nombre = rs.getString("cliente_nombre");
                String apellido = rs.getString("cliente_apellido");
                String email = rs.getString("cliente_email");
                int edad = rs.getInt("cliente_edad");
                String telefono = rs.getString("cliente_telefono");
                double saldo = rs.getDouble("cliente_saldo");
            
                /* Creamos un nuevo objeto y asignamos a la variable de cliente */
                cliente = new Cliente(idCliente, nombre, apellido, edad, email, telefono, saldo);
            
                /* Agregamos el objeto a la lista de clientes */
                clientes.add(cliente);
            }
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return clientes;
    }
    
    /* Encontrar un objeto de tipo cliente */
    /* Es decir un by id */
    public Cliente encontrar(Cliente cliente) {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            /* Enviamos los argumentos */
            stmt.setInt(1, cliente.getIdCliente());
            
            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                int idCliente = rs.getInt("cliente_id");
                String nombre = rs.getString("cliente_nombre");
                String apellido = rs.getString("cliente_apellido");
                int edad = rs.getInt("cliente_edad");
                String email = rs.getString("cliente_email");
                String telefono = rs.getString("cliente_telefono");
                double saldo = rs.getDouble("cliente_saldo");
            
                /* Creamos un nuevo objeto y asignamos a la variable de cliente */
                cliente = new Cliente(idCliente, nombre, apellido, edad, email, telefono, saldo);
            }
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return cliente;
    }

    /* Insertar un registro de tipo cliente */
    /* Regresara un entero para confirmar las row afectadas */
    public int insertar(Cliente cliente){
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /* Cuando recuperamos informacion usamos el ResultSet */
        /* Pero cuando se quieren afectar filas no se usa  */
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement(SQL_INSERT);
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setString(1, cliente.getNombreCliente());
            stmt.setString(2, cliente.getApellidoCliente());
            stmt.setInt(3, cliente.getEdadCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getTelefonoCliente());
            stmt.setDouble(6, cliente.getSaldoCliente());
            
            /* Almacenamos la cantidad de registros que se han modificado */
            rows = stmt.executeUpdate();
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    /* Actualizar, ya la sabemos */
    public int actualizar(Cliente cliente){
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /* Cuando recuperamos informacion usamos el ResultSet */
        /* Pero cuando se quieren afectar filas no se usa  */
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement(SQL_UPDATE);
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setString(1, cliente.getNombreCliente());
            stmt.setString(2, cliente.getApellidoCliente());
            stmt.setInt(3, cliente.getEdadCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getTelefonoCliente());
            stmt.setDouble(6, cliente.getSaldoCliente());
            stmt.setInt(7, cliente.getIdCliente());
            
            /* Almacenamos la cantidad de registros que se han modificado */
            rows = stmt.executeUpdate();
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    /* El de delete de toda la vida */
    public int eliminar(Cliente cliente) {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /* Cuando recuperamos informacion usamos el ResultSet */
        /* Pero cuando se quieren afectar filas no se usa  */
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement(SQL_DELETE);
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, cliente.getIdCliente());
            
            /* Almacenamos la cantidad de registros que se han modificado */
            rows = stmt.executeUpdate();
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
}
