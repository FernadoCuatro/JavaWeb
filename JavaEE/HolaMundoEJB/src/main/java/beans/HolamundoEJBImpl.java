package beans;

import javax.ejb.Stateless;

/**
 *
 * @author Fernando Cuatro
 */
/* Para que sea un EJB */
@Stateless
/* He implementamos la interfaz del mismo paquete */
public class HolamundoEJBImpl implements HolaMundoEJBRemote {

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutanto metodo suma en el servidor");
        return a + b;
    }
    
}
