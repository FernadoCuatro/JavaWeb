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
    @NamedQuery(name = "Motorista.findAll", query = "SELECT m FROM Motorista m ORDER BY m.idMotorista")
})

@Table(name = "motorista") /* Por si el nombre de la tabla no coicide */
/* Debe de implementarse el Serializable */
public class Motorista implements Serializable {
    private static final long SerialVersionUID = 1L;
    
    /* Atributos de la clase */
    
    /* Especificamos cual es el ID para que mapee con la primaria de la base de datos */
    @Id /* Especificamos que es la primaria */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Con esto configuramos y le decimos que la primaria es autoincrementable */
    @Column(name = "idmotorista")
    /* Renombramos para hacer el mapeo correctamente */
    private int idMotorista;
    
    /* Son los mismos nombres desde la base de datos, por lo tanto, no hay inconvenientes */
    @Column(name = "dui_motorista")
    private String diuMotorista;
    
    @Column(name = "nombre_motorista")
    private String nombreMotorista;
    
    @Column(name = "apellido_motorista")
    private String apellidoMotorista;
    
    private String telefono;
    
    @Column(name = "empresa_pertenece")
    private String empresaPertenece;
    
    /* Contructor vacio */
    public Motorista() {
    }
    
    /* Constructor sin el ID */
    public Motorista(String diuMotorista, String nombreMotorista, String apellidoMotorista, String telefono, String empresaPertenece) {
        this.diuMotorista = diuMotorista;
        this.nombreMotorista = nombreMotorista;
        this.apellidoMotorista = apellidoMotorista;
        this.telefono = telefono;
        this.empresaPertenece = empresaPertenece;
    }
    
    /* Metodos accesores */
    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getDiuMotorista() {
        return diuMotorista;
    }

    public void setDiuMotorista(String diuMotorista) {
        this.diuMotorista = diuMotorista;
    }

    public String getNombreMotorista() {
        return nombreMotorista;
    }

    public void setNombreMotorista(String nombreMotorista) {
        this.nombreMotorista = nombreMotorista;
    }

    public String getApellidoMotorista() {
        return apellidoMotorista;
    }

    public void setApellidoMotorista(String apellidoMotorista) {
        this.apellidoMotorista = apellidoMotorista;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresaPertenece() {
        return empresaPertenece;
    }

    public void setEmpresaPertenece(String empresaPertenece) {
        this.empresaPertenece = empresaPertenece;
    }
    
    /* El Override del metodo ToString */
    @Override
    public String toString() {
        return "Motorista{" + "idMotorista=" + idMotorista + ", diuMotorista=" + diuMotorista + ", nombreMotorista=" + nombreMotorista + ", apellidoMotorista=" + apellidoMotorista + ", telefono=" + telefono + ", empresaPertenece=" + empresaPertenece + '}';
    }
    
}
