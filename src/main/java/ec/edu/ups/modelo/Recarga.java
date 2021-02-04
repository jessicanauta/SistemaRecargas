package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recarga implements Serializable{
	
	//Atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecarga;
	
	private int numero;
	private double saldo;
	private String operadora;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id")
    private Telefono telefono;
	
	/** 
	 * Metodo que permite obtener el atributo recarga 
	 * @return El atributo recarga de esta clase
	 */
	public int getIdRecarga() {
		return idRecarga;
	}
	
	/** 
	 * Metodo que permite asignarle un valor al atributo recarga 
	 * @param recarga parametro para poder obtener 
	 */
	public void setIdRecarga(int idRecarga) {
		this.idRecarga = idRecarga;
	}
	
	/** 
	 * Metodo que permite obtener el atributo numero 
	 * @return El atributo numero de esta clase
	 */
	public int getNumero() {
		return numero;
	}
	
	/** 
	 * Metodo que permite asignarle un valor al atributo numero 
	 * @param numero parametro para poder obtener 
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/** 
	 * Metodo que permite obtener el atributo saldo 
	 * @return El atributo saldo de esta clase
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/** 
	 * Metodo que permite asignarle un valor al atributo saldo 
	 * @param saldo parametro para poder obtener 
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/** 
	 * Metodo que permite obtener el atributo operadora 
	 * @return El atributo operadora de esta clase
	 */
	public String getOperadora() {
		return operadora;
	}
	
	/** 
	 * Metodo que permite asignarle un valor al atributo operadora 
	 * @param operadora parametro para poder obtener 
	 */
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	/** 
	 * Metodo que permite obtener el atributo telefono 
	 * @return El atributo telefono de esta clase
	 */
	public Telefono getTelefono() {
		return telefono;
	}

	
	/** 
	 * Metodo que permite asignarle un valor al atributo telefono 
	 * @param telefono parametro para poder obtener 
	 */
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	
	
}
