package beans.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Fernando Cuatro
 */


@Named /* Para que pueda ser reconocida por el framework de JSF */
@RequestScoped /* Despues del Named, especificamos el alcance que tendra */
public class Candidato {
    /* Esta clase se relacionara con la pagina HTML de JSF */
    
    Logger log = LogManager.getRootLogger();
    
    /* Atributo */
    private String nombre;
    private String apellido;
    private String salarioDeseado;

    /* Constructor vacio */
    public Candidato() {
        log.info("Creando el objeto Candidato");
        this.setNombre("Introduce tu nombre");
    }
    
    
    /* Metodos accesores */
    public String getNombre() {
        return nombre;
    }

    /* Cuando hagamos un set, lo que queremos es mandarlo a consola para saber en que fase se esta manejando */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre: " + this.nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        log.info("Modificando la propiedad de apellido: " + this.apellido);
    }

    public String getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(String salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando la propiedad de salario deseado: " + this.salarioDeseado);
    }

    
    
    
}
