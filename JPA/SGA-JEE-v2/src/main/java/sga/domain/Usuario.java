/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sga.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Fernando Cuatro
 */
@Entity
@NamedQueries(
{
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) 
    @Column(name = "id_usuario")
    private Integer idUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String username;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String password;
    
    /* Relacion entre la Persona y Usuario */
    /* De muchos a uno */
    /* Con la columna que se esta relacionando que es id_persona */
    /* La primera columna hace referenica a la tabla usuario, y la segunda a la tabla persona */
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    /* Este atributo esta definido como dato de tipo persona, es decir que trae un objeto de tipo persona */
    private Persona persona;

    /* Contructores */
    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /* Metodos accesores */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /* Y le sabemos para que es */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }
    
    /* Y le sabemos para que es */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario))
        {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario)))
        {
            return false;
        }
        return true;
    }

    /* Se traen todos los datos incluyendo el de persona, que es un objeto */
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", persona=" + persona + '}';
    }
    
}
