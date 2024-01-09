package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.*;

/**
 *
 * @author Fernando Cuatro
 */
public class TestManejoPersonas {

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  PersonaDAO personaDAO = new PersonaDAO();

  System.out.println("Personas\n¿Que desea hacer?");
  System.out.println("1. Lista de personas");
  System.out.println("2. Añadir una persona");
  System.out.println("3. Editar persona");
  System.out.println("4. Eliminar persona");
  int opcion = sc.nextInt();
  sc.nextLine();
  
  switch (opcion)
  {
   case 1:
    // Lista de personas
    System.out.println("\nLista de personas:");
    
    personaDAO.listarPersonas();
    break;

   case 2:
    // Insertando un nuevo objeto de tipo persona en la base de datos
    System.out.println("\nInsertar un nuevo registro:");
    
    System.out.println("---\nIngrese los datos requeridos.");
    System.out.println("Nombre: ");
    String nombre = sc.nextLine();

    System.out.println("\nApellido: ");
    String apellido = sc.nextLine();

    System.out.println("\nEmail: ");
    String email = sc.nextLine();

    System.out.println("\nTelefono: ");
    String telefono = sc.nextLine();

    Persona personaInsertar = new Persona(nombre, apellido, email, telefono);

    if (personaDAO.insertar(personaInsertar) > 0)
    {
     System.out.println("\n----\nSe inserto el dato correctamente. Lista de Personas:");
     personaDAO.listarPersonas();
    }
    break;

   case 3:
    // Actualizar Persona
    System.out.println("\nLista de personas, seleccione el ID de la persona a editar: ");
    personaDAO.listarPersonas();
    
    System.out.println("ID a editar: ");
    int idEditar = sc.nextInt();
    sc.nextLine();
    
    System.out.println("---\nIngrese los datos requeridos.");
    System.out.println("Nombre: ");
    nombre = sc.nextLine();

    System.out.println("\nApellido: ");
    apellido = sc.nextLine();

    System.out.println("\nEmail: ");
    email = sc.nextLine();

    System.out.println("\nTelefono: ");
    telefono = sc.nextLine();

    Persona personaActualizar = new Persona(idEditar, nombre, apellido, email, telefono);
    
    if (personaDAO.actualizar(personaActualizar) > 0)
    {
     System.out.println("\n----\nSe actualizo el dato correctamente. Lista de Personas:");
     personaDAO.listarPersonas();
    }
    break;

   case 4:
    // Suprimir persona
    System.out.println("\nLista de personas, seleccione el ID de la persona a eliminar: ");
    personaDAO.listarPersonas();
    
    System.out.println("ID a editar: ");
    int idEliminar = sc.nextInt();
    
    Persona personaEliminar = new Persona(idEliminar);
    
    if (personaDAO.eliminar(personaEliminar)> 0)
    {
     System.out.println("\n----\nSe elimino el dato correctamente. Lista de Personas:");
     personaDAO.listarPersonas();
    }
    
    break;

   default:
    System.out.println("\n------\nOpcion no valida\n------\n");
  }

 }
}
