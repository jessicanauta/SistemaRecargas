package ec.edu.ups.controlador;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Recarga;

/** 
 * Esta clase me permite hacer las funciones basicas en una base de datos utilizando la clase Recarga 
 * @version 1.0 
 * 
 */

@Stateless
public class RecargaDAO {


			@PersistenceContext(name = "SistemaRecargaPersistenceUnit") 
			private EntityManager em;
			
			/** 
			 * Metodo que permite registrar una recarga en la base de datos
			 * @param r Recarga que se va a registrar en la base
			 */
			public void insert(Recarga r) {
				if (read( r.getIdRecarga()) != null) {
					em.persist(r);
				} else {
					update(r);
				}
			}
			
			/** 
			 * Metodo que permite actualizar una recarga en la base de datos
			 * @param r Recarga que se va a actualizar en la base
			 */
			public void update(Recarga r) {
				em.merge(r);
			} 
			
			/** 
			 * Metodo que permite obtener una recarga de la base de datos
			 * @param id que se utilizara para obtener la recarga
			 * @return una recarga que se encuentre registrado en la base
			 */
			public Recarga read(int id) {
				return em.find(Recarga.class, id);
			} 
			
			/** 
			 * Metodo que permite eliminar una recarga de la base de datos
			 * @param id utilizaremos para poder eliminar la recarga
			 */
			public void delete(int id) {
				Recarga r = read(id);
				em.remove(r);
			}
			
			/** 
			 * Metodo que permite obtener las recargas que estan registrados en la base de datos
			 * @return Lista de recargas que estan registrados en la base de datos
			 */
			public List<Recarga> getRecargas() {
				String jpql = "SELECT r FROM Recarga r";

				Query q = em.createQuery(jpql, Recarga.class);
				return q.getResultList();
			} 
}
