package beans;

import javax.ejb.Remote;

/**
 *
 * @author Fernando Cuatro
 */
/* Notacion para que la pueda mandar a llamar de forma remota */
@Remote
public interface HolaMundoEJBRemote {
    public int sumar(int a, int b);
}
