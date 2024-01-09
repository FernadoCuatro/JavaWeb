package beans.configuracion;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

/**
 *
 * @author Fernando Cuatro
 */

/* Notacion 1 */
@FacesConfig (
    /* Esto activa el CDI build-in para los beans que vamos a contruir */
    version = JSF_2_3
)

/* Notacion 2 | Le decimos que vamos a estar trabajando con la ultima version de JSF */
@ApplicationScoped
public class configuracionJSF {
    
}
