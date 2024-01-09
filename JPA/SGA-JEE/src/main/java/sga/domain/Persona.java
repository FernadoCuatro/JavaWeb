package sga.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Fernando Cuatro
 */

/* Convertimos en una clase entidad para interactuar con el api de JPA hacia la bd */
@Entity
/* Se puede hacer esto para recuperar datos por medio de consultas */
/* El nombre puede ser cualquiera */
/* Recupera objetos y no columnas, En la Query no es SQL es JPQL - Por lo tando el id_persona es idPersona */
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.idPersona")
})

@Table(name = "persona") /* Por si el nombre de la tabla no coicide */
/* Debe de implementarse el Serializable */
public class Persona implements Serializable {
    private static final long SerialVersionUID = 1L;
    
    /* Atributos de la clase */
    
    /* Especificamos cual es el ID para que mapee con la primaria de la base de datos */
    @Id /* Especificamos que es la primaria */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Con esto configuramos y le decimos que la primaria es autoincrementable */
    @Column(name = "id_persona")
    /* Renombramos para hacer el mapeo correctamente */
    private int idPersona;
    
    /* Son los mismos nombres desde la base de datos, por lo tanto, no hay inconvenientes */
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    /* Constructores */
    public Persona() {
    }

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    
    /* Metodos accesores */
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /* Sobre escribimos el metodo toString */
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
}
