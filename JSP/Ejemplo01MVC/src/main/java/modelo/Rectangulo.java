package modelo;

/**
 *
 * @author Fernando Cuatro
 */
public class Rectangulo {
    private int base;
    private int altura;

    /* Contructor vacio */
    public Rectangulo() {
    }
    
    /* Contructor con dos argumentos */
    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    
    /* Setter y Getter */
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
    
    /* Metodo para obtener el area */
    public int getArea(){
        return this.base * this.altura;
    }
}
