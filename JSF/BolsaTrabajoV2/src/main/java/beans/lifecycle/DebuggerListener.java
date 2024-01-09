/* 
    Esta clase va a funcionar como un listener para  
    Enviar un mensaje media vez se acabe el cliclo de vida del JSF
*/
package beans.lifecycle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Fernando Cuatro
 */

/* Implementamos la interface */
public class DebuggerListener implements javax.faces.event.PhaseListener {
    /* Implementamos los metodos de esa interfaz */
    
    /* Mandamos mensajes a la consola utilizando el API log4j  */
    Logger log = LogManager.getRootLogger();
    
    /* 
        Ciclo de vida de un JSF 
        1. Restauracion de la vista
        2. Procesamiento Parametros
        3. Procesamiento validadores
        4. Procesamiento del modelo
        5. Invocacion de la aplicacion
    */
    
    /* Antes */
    @Override
    public void beforePhase(PhaseEvent pe) {
        if (log.isInfoEnabled())
        {
            /* Si esta habilitado este nivel, mandamos la informacion */
            /* Para saber en que etapa estamos */
            log.info("Antes de la fase: " + pe.getPhaseId().toString());
        }
    }

    /* Despues */
    @Override
    public void afterPhase(PhaseEvent pe) {
        if (log.isInfoEnabled())
        {
            /* Si esta habilitado este nivel, mandamos la informacion */
            /* Para saber en que etapa estamos */
            log.info("Despues de la fase: " + pe.getPhaseId().toString());
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
