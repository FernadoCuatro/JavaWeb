package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Fernando Cuatro
 */
@Named /* Para que pueda ser reconocida por JSF */
@RequestScoped 
public class VacanteForm {
    /* Agregamos la inyeccion del objeto candidato del otro ManajeBeans que hemos definido */
    
    /* Usamos CDI */
    @Inject
    private Candidato candidato;
    
    /* La configuracion de salida en consola */
    Logger log = LogManager.getRootLogger();

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    /* Redireccioamos a otra pagina */
    public String enviar(){
        String envio = "";
        
        if (this.candidato.getNombre().equals("Fernando"))
        {
            log.info("Entrando al caso de exito.");
            envio = "exito";
        }else{
            log.info("Estamos en segunda, fallo.");
            envio = "fallo";
        }
    
        return envio;
    }
    
}
