package domain;

/**
 *
 * @author Fernando Cuatro
 */
public class PersonaDTO {

 // Tabla de entidad
 // Cada atributo representa una columna de la base de datos
 private int idPersona;
 private String nombre;
 private String apellido;
 private String email;
 private String telefono;

 // Constructor vacio
 public PersonaDTO() {
 }
 
 // Solo manejando con el id, como para eliminar
 public PersonaDTO(int idPersona) {
  this.idPersona = idPersona;
 }
 
 // Registro para insertar sin el id
 public PersonaDTO(String nombre, String apellido, String email, String telefono) {
  this.nombre = nombre;
  this.apellido = apellido;
  this.email = email;
  this.telefono = telefono;
 }
 
 // Para modificar un registro o mostrarlo y recorrelos como objetos
 public PersonaDTO(int idPersona, String nombre, String apellido, String email, String telefono) {
  this.idPersona = idPersona;
  this.nombre = nombre;
  this.apellido = apellido;
  this.email = email;
  this.telefono = telefono;
 }
 
 // Para modificar los datos de algun atributo en individual, agregamos el get y set

 public int getIdPersona() {
  return idPersona;
 }

 public void setIdPersona(int idPersona) {
  this.idPersona = idPersona;
 }

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public String getApellido() {
  return apellido;
 }

 public void setApellido(String apellido) {
  this.apellido = apellido;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getTelefono() {
  return telefono;
 }

 public void setTelefono(String telefono) {
  this.telefono = telefono;
 }
 
 // Sobreescribir el metodo ToString() para poder usarlo para imprimir el estado del objeto
 @Override
 public String toString() {
  return "Persona{" + "idPersona = " + idPersona + ", nombre = " + nombre + ", apellido = " + apellido + ", email = " + email + ", telefono = " + telefono + '}';
 }
 
}
