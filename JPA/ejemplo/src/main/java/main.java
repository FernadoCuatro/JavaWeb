/**
 *
 * @author Fernando Cuatro
 */
public class main {

    public static void main(String[] args) {
        int nIzq = 10;
        int nMin  = 1;
        String salida = "";
        
        while (nIzq >= nMin)
        {
            while (nMin <= nIzq)
            {
                if (nMin >= nIzq)
                {
                    salida = "*";
                } else
                {
                    salida = " ";
                }
                
                System.out.println(salida);
                nMin += 1;
            }
            
            nIzq -= 1;
        }
        
    }
    
}
