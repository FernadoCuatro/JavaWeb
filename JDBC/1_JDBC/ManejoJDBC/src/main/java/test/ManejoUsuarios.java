package test;

import datos.UsuarioDAO;

/**
 *
 * @author Fernando Cuatro
 */
public class ManejoUsuarios {

 public static void main(String[] args) {
  UsuarioDAO usuarioDAO = new UsuarioDAO();

  // Insertando datos, queda comentado para que no se repitan los datos
  //  System.out.println("Insertando registros a la tabla usuarios");
  //  Usuario usuarioInsertar = new Usuario("Dan", "clave");
  //  
  //  if (usuarioDAO.insertar(usuarioInsertar) > 0)
  //  {
  //   System.out.println("El usuario se inserto correctamente, Lista de usuarios:");
  //   usuarioDAO.listarUsuario();
  //  }
  // Actualizando datos, queda comentado por efectos del ejercicio
  //  Usuario usuarioEditar = new Usuario(3, "Ana", "2023448@");
  //  if (usuarioDAO.actualizar(usuarioEditar) > 0)
  //  {
  //   System.out.println("El usuario se actualizo correctamente, Lista de usuarios:");
  //   usuarioDAO.listarUsuario();
  //  }
  // Eliminando los datos, igual comentado xd
  //  Usuario usuarioEliminar = new Usuario(2);
  //  if (usuarioDAO.eliminar(usuarioEliminar) > 0)
  //  {
  //   System.out.println("El usuario se elimino correctamente, Lista de usuarios:");
  //   usuarioDAO.listarUsuario();
  //  }
  System.out.println("Lista de usuarios por defecto:");
  usuarioDAO.listarUsuario();

 }
}
