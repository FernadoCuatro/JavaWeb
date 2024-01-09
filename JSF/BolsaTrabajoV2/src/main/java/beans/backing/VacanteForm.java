package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    
    /* Contructor vacio */
    public VacanteForm() {
        log.info("Crenado el objeto VacanteForm");
    }
    
    
    /* La configuracion de salida en consola */
    Logger log = LogManager.getRootLogger();

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    /* Redireccioamos a otra pagina */
    public String enviar(){
        String envio = "";
        String msg = "";
        
        if (this.candidato.getNombre().equals("Fernando"))
        {
            if (this.candidato.getApellido().equals("Cuatro"))
            {
                msg = "Gracias, pero Fernando Cuatro esta bloqueado.";
                /* Mandamos el mensaje a la pagina Jsf */
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                
                /* Paraa decirle que no esta relacionada con ningun componente, si no que es global */
                String componentId = null;
                
                /* Enviamos el mensaje, definineido el componente y la referencia del objeto */
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            
            log.info("Entrando al caso de exito.");
            envio = "exito";
        }else{
            log.info("Estamos en segunda, fallo.");
            envio = "fallo";
        }
    
        return envio;
    }
    
}
