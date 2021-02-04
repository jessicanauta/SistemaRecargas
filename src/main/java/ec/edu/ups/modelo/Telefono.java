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
public class Telefono implements Serializable{
	
	//Atributos de la  clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double saldo;
	private int numero;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cedula")
    private Cliente cliente;
	
	@OneToMany(mappedBy = "telefono", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Recarga> listaRecargas;
	
	/** 
	 * Metodo que permite obtener el atributo id 
	 * @return El atributo id de esta clase
	 */	
	public int getId() {
		return id;
	}
	
	/** 
	 * Metodo que permite asignarle un valor al atributo id 
	 * @param id parametro para poder obtener 
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Metodo que permite obtener el atributo cliente 
	 * @return El atributo cliente de esta clase
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/** 
	 * Metodo que permite asignarle un valor al atributo cliente 
	 * @param cliente parametro para poder obtener 
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/** 
	 * Metodo que permite obtener el atributo listaRecargas 
	 * @return El atributo listaRecargas de esta clase
	 */
	public List<Recarga> getListaRecargas() {
		return listaRecargas;
	}

	/** 
	 * Metodo que permite asignarle un valor al atributo listaRecargas 
	 * @param listaRecargas parametro para poder obtener 
	 */
	public void setListaRecargas(List<Recarga> listaRecargas) {
		this.listaRecargas = listaRecargas;
	}
	
	
	

}
