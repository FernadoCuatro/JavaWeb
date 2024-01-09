package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fernando Cuatro
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Solicitamos el parametro de accion */
        String accion = request.getParameter("accion");

        if (accion != null)
        {
            switch (accion)
            {
                case "editar":
                    this.EditarCliente(request, response);
                    break;

                case "eliminar":
                    this.EliminarCliente(request, response);
                    break;

                default:
                    this.cargarInicio(request, response);
            }
        } else
        {
            this.cargarInicio(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Solicitamos el parametro de accion */
        String accion = request.getParameter("accion");

        if (accion != null)
        {
            switch (accion)
            {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;

                case "modificar":
                    this.modificarCliente(request, response);
                    break;

                default:
                    this.cargarInicio(request, response);
            }
        } else
        {
            this.cargarInicio(request, response);
        }

    }

    /* Carga y lista a todos los clientes */
    private void cargarInicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recupera los clientes y lo comparte */
        List<Cliente> clientes = new ClienteDaoJDBC().Listar();

        /* Usamos el alcance de sesion */
        HttpSession sesion = request.getSession();

        sesion.setAttribute("clientes", clientes);
        /* Compartimos los datos que usaremos en la card del listado Cliente */
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        sesion.setAttribute("totalClientes", clientes.size());

        /* El forward hace el proceso sin que el navegador se entere, es decir */
        /* request.getRequestDispatcher("clientes.jsp").forward(request, response); */
        /* No hay cambio en la url, por eso se usa eso cambia y limpia la url */
        response.sendRedirect("clientes.jsp");
    }

    /* Metodo para insertar un cliente */
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recuperamos los valores del formulario */
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");

        /* Validamos el saldo */
        if (saldoString != null && !"".equals(saldoString))
        {
            saldo = Double.parseDouble(saldoString);
        }

        /* Creamos el objeto de cliente (modelo) */
        Cliente cliente = new Cliente(nombre, apellido, edad, email, telefono, saldo);

        /* Insertamos en la base de datos */
        /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new ClienteDaoJDBC().insertar(cliente);

        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarInicio(request, response);
        }

    }

    /* Metodo para editar un cliente */
    private void EditarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperamos el id del cliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        /* Reuperamos la infomacion el objeto del cliente por medio del id */
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/WEB-INF/templates/cliente/editarClientes.jsp").forward(request, response);
    }

    /* Metodo para modificar el cliente */
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Recuperamos los valores del formulario */
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");

        /* Validamos el saldo */
        if (saldoString != null && !"".equals(saldoString))
        {
            saldo = Double.parseDouble(saldoString);
        }

        /* Creamos el objeto de cliente (modelo) */
        Cliente cliente = new Cliente(idCliente, nombre, apellido, edad, email, telefono, saldo);

        /* Modificamos en la base de datos */
 /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new ClienteDaoJDBC().actualizar(cliente);

        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarInicio(request, response);
        }

    }

    /* Metodo para eliminar un cliente */
    private void EliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Recuperamos los valores del formulario */
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        /* Creamos el objeto de cliente (modelo) */
        Cliente cliente = new Cliente(idCliente);

        /* Modificamos en la base de datos */
         /* Utilizamos la capa de datos es decir el DAO */
        int registroModificado = new ClienteDaoJDBC().eliminar(cliente);

        /* Cuando se procese la informacion en la base de datos, redirigimos a la accion por defecto */
        if (registroModificado > 0)
        {
            this.cargarInicio(request, response);
        }
    }

    /* Metodo para calcular el total de saldo de todos los clientes */
    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;

        /* Recorremos todos nuestros clientes */
        for (Cliente cliente : clientes)
        {
            saldoTotal += cliente.getSaldoCliente();
        }

        return saldoTotal;
    }
}
