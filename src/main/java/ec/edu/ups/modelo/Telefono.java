package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Telefono implements Serializable {

	// Atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTefono;

	private double saldo;
	private double saldoAnterior;
	private String numero;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cedula")
	private Cliente cliente;

	/**
	 * Metodo que permite obtener el atributo id
	 * 
	 * @return El atributo id de esta clase
	 */
	public int getIdTefono() {
		return idTefono;
	}

	/**
	 * Metodo que permite asignarle un valor al atributo id
	 * 
	 * @param id parametro para poder obtener
	 */
	public void setIdTefono(int idTefono) {
		this.idTefono = idTefono;
	}

	/**
	 * Metodo que permite obtener el atributo saldo
	 * 
	 * @return El atributo saldo de esta clase
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Metodo que permite asignarle un valor al atributo saldo
	 * 
	 * @param saldo parametro para poder obtener
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Metodo que permite obtener el atributo numero
	 * 
	 * @return El atributo numero de esta clase
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Metodo que permite asignarle un valor al atributo numero
	 * 
	 * @param numero parametro para poder obtener
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Metodo que permite obtener el atributo cliente
	 * 
	 * @return El atributo cliente de esta clase
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Metodo que permite asignarle un valor al atributo cliente
	 * 
	 * @param cliente parametro para poder obtener
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	@Override
	public String toString() {
		return "Telefono [idTefono=" + idTefono + ", saldo=" + saldo + ", saldoAnterior=" + saldoAnterior + ", numero="
				+ numero + ", cliente=" + cliente + "]";
	}
	
	

}
