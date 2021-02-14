package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{
	
	//Atributos de la entidad
		@Id 
		private String cedula; 
		private String nombre; 
		private String apellido; 
		private String correo;
		
		/** 
		 * Constructor de la clase 
		 */
		public Cliente() {

		} 
		/** 
		 * Metodo que permite obtener el atributo cedula 
		 * @return El atributo cedula de esta clase
		 */
		public String getCedula() {
			return cedula;
		}  
		
		/** 
		 * Metodo que permite asignarle un valor al atributo cedula 
		 * @param cedula parametro para poder obtener 
		 */
		public void setCedula(String cedula) {
			this.cedula = cedula;
		} 
		
		/** 
		 *  Metodo que permite obtener el atributo nombre  
		 * @return El atributo nombre de esta clase
		 */
		public String getNombre() {
			return nombre;
		} 
		
		/** 
		 * Metodo que permite asignarle un valor al atributo nombre 
		 * @param cedula Variable que se asigna al atributo de la clase
		 */
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		} 
		
		/** 
		 * Metodo que permite obtener el atributo apellido 
		 * @return El atributo apellido de esta clase
		 */
		public String getApellido() {
			return apellido;
		} 
		
		/** 
		 * Metodo que me permite asignarle un valor al atributo apellido 
		 * @param apellido Variable que se asigna al atributo de la clase
		 */
		public void setApellido(String apellido) {
			this.apellido = apellido;
		} 
			
		/** 
		 * Metodo que permite obtener el atributo correo 
		 * @return El atributo correo de esta clase
		 */
		public String getCorreo() {
			return correo;
		} 
		
		/** 
		 * Metodo que me permite asignarle un valor al atributo correo
		 * @param correo variable que se asigna al atributo de la clase
		 */
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		@Override
		public String toString() {
			return "Cliente [cedula=" + cedula + ", nombre=" + nombre
					+ "]";
		}
		
		
}
