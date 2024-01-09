package domain;

/**
 *
 * @author Fernando Cuatro
 */
public class Usuario {

 private int idUsuario;
 private String usuario;
 private String password;

 // Definimos constructores 
 // Por omision o defecto
 public Usuario() {
 }

 // Constructor solo con el ID, para eliminar puede servir
 public Usuario(int idUsuario) {
  this.idUsuario = idUsuario;
 }

 // Constructor con todos los datos menos con el ID, este es para insertar
 public Usuario(String usuario, String password) {
  this.usuario = usuario;
  this.password = password;
 }
 
 // Constructor con todos los datos, puede servir para editar
 public Usuario(int idUsuario, String usuario, String password) {
  this.idUsuario = idUsuario;
  this.usuario = usuario;
  this.password = password;
 }
 
 // Los get y set para cada uno de los atributos
 public int getIdUsuario() {
  return idUsuario;
 }

 public void setIdUsuario(int idUsuario) {
  this.idUsuario = idUsuario;
 }

 public String getUsuario() {
  return usuario;
 }

 public void setUsuario(String usuario) {
  this.usuario = usuario;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }
 
 // Sobre escribimos el metodo String 
 @Override
 public String toString() {
  return "Usuario {" + "idUsuario = " + idUsuario + ", usuario = " + usuario + ", password = " + password + '}';
 }
 
}
