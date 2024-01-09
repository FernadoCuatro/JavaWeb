package beans;

/**
 *
 * @author Fernando Cuatro
 */
public class Rectangulo {
    /* Los atributos tienen que ser privadas */
    private int base;
    private int altura;
    
    /* Contiene un constructor vacio, por default para considerarse con JavaBeans */
    /* Si se agrega mas de un constructor personalizado, se debe agregar el constructor vacio */
    /* Pero si no, al momento de compilar lo hace automaticamente */
    public Rectangulo() {
    }
    
    /* Metodos de acceso */
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int getArea(){
        return this.base * this.altura;
    }
}
