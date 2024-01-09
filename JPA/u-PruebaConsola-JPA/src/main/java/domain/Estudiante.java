package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Fernando Cuatro
 */

/* Convertimos en una clase entidad para interactuar con el api de JPA hacia la bd */
@Entity
@Table(name = "estudiante") /* Si acazo tiene un nombre diferente */
/* Debe de implementarse el Serializable */
public class Estudiante implements Serializable {
    private static final long SerialVersionUID = 1L;
    
    /* Atributos de la clase */
    
    /* Especificamos cual es el ID para que mapee con la primaria de la base de datos */
    @Id /* Especificamos que es la primaria */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Con esto configuramos y le decimos que la primaria es autoincrementable */
    @Column(name = "id_estudiante")
    /* Renombramos para hacer el mapeo correctamente */
    private int idEstudiante;
    
    /* Son los mismos nombres desde la base de datos, por lo tanto, no hay inconvenientes */
    private String carnet;
    
    @Column(name = "nombre_estudiante")
    private String nombre;
    @Column(name = "apellido_estudiante")
    private String apellido;
    
    private int edad;
    private String direccion;
    
    /* Constructores */
    public Estudiante() {
    }
    
    /* Constructor sin el ID, ya que se va a generar cuando se haga el proceso */
    public Estudiante(String carnet, String nombre, String apellido, int edad, String direccion) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
    }
    
    /* Metodos accesores */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /* Metodo ToString para la salida hacemos Override */
    @Override
    public String toString() {
        return "Estudiante{" + "idEstudiante=" + idEstudiante + ", carnet=" + carnet + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", direccion=" + direccion + '}';
    }
    
}
