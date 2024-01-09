package dominio;

/**
 *
 * @author Fernando Cuatro
 */
public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int edadCliente;
    private String emailCliente;
    private String telefonoCliente;
    private double saldoCliente;

    /* Constructor vacio */
    public Cliente() {
    }

    /* Constructor solamente con el id */
    /* Por ejemplo para el Delete, se usa este */
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /* Este se puede utilizar cuando se hace un insert */
    public Cliente(String nombreCliente, String apellidoCliente, int edadCliente, String emailCliente, String telefonoCliente, double saldoCliente) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.edadCliente = edadCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.saldoCliente = saldoCliente;
    }
    
    /* Este para el update, por ejemplo; p para mostrar tambien */
    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, int edadCliente, String emailCliente, String telefonoCliente, double saldoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.edadCliente = edadCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.saldoCliente = saldoCliente;
    }
   
    /* Metodos accesores */
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    
    
    /* Para hacer pruebas de salida en consola */
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", emailCliente=" + emailCliente + ", telefonoCliente=" + telefonoCliente + ", saldoCliente=" + saldoCliente + '}';
    }
}
