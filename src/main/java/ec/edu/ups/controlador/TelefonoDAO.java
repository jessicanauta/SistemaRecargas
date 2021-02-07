package ec.edu.ups.controlador;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Telefono;

/** 
 * Esta clase me permite hacer las funciones basicas en una base de datos utilizando la clase Telefono 
 * @version 1.0 
 * 
 */

@Stateless
public class TelefonoDAO {
	
	//Atributo de la clase
	@PersistenceContext(name = "SistemaRecargaPersistenceUnit") 
	private EntityManager em;
	
	/** 
	 * Metodo que permite registrar un telefono en la base de datos
	 * @param t Telefono que se va a registrar en la base
	 */
	public void insert(Telefono t) {
		if (read(t.getIdTefono()) != null) {
			em.persist(t);
		} else {
			update(t);
		}
	}
	
	/** 
	 * Metodo que permite actualizar un telefono en la base de datos
	 * @param t Telefono que se va a actualizar en la base
	 */
	public void update(Telefono t) {
		em.merge(t);
	} 
	
	/** 
	 * Metodo que permite obtener una recarga de la base de datos
	 * @param id que se utilizara para obtener la recarga
	 * @return una recarga que se encuentre registrado en la base
	 */
	public Telefono read(int id) {
		return em.find(Telefono.class, id);
	} 
	
	/** 
	 * Metodo que permite eliminar un telefono de la base de datos
	 * @param id utilizaremos para poder eliminar el telefono
	 */
	public void delete(int id) {
		Telefono t = read(id);
		em.remove(t);
	}
	
	/** 
	 * Metodo que permite obtener los telefonos que estan registrados en la base de datos
	 * @return Lista de telefonos que estan registrados en la base de datos
	 */
	public List<Telefono> getTelefonos() {
		String jpql = "SELECT t FROM Telefono t";

		Query q = em.createQuery(jpql, Telefono.class);
		return q.getResultList();
	} 

}
