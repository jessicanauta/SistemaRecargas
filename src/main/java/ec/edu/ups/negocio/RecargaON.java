package ec.edu.ups.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.controlador.RecargaDAO;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Recarga;

/**
 * Esta clase me permite hacer diferentes validaciones o metodos necesarios
 * antes de poder realizar las diferentes funciones basicas en la base de datos
 */

@Stateless
public class RecargaON {
	
	@Inject 
	private RecargaDAO recargadao;

	public RecargaON() throws Exception{
		super();
	}
	
	/**
	 * Metodo que me permite guardar la recarga en la base de datos
	 * 
	 * @param recarga Recarga que se guarda en la base de datos
	 */
	public void guardarRecarga(Recarga recarga) throws Exception {
		try {
			Recarga aux = recargadao.read(recarga.getIdRecarga());

			if (aux != null) {
				recargadao.update(recarga);
			} else {
				recargadao.insert(recarga);
			}

		} catch (Exception e) {
				throw new Exception("Error al ingresar recarga");
		}
	}
	
	/**
	 * Metodo que permite la busqueda de un recarga
	 * 
	 * @param id de la recarga que se busca
	 * @return Recarga obtenido de la busqueda
	 */
	public Recarga buscarRecarga(int id) {
		return recargadao.read(id);
	}
	
	/**
	 * Metodo que permite actualizar una recarga
	 * 
	 * @param recarga Recarga que se actualiza
	 */
	public void actualizarRecarga(Recarga recarga) throws Exception{
        try {
        	recargadao.update(recarga);
        } catch (Exception e) {
        	throw new Exception("Error al actualizar la recarga");
        }
    }
	
	/**
	 * Metodo que permite eliminar una recarga
	 * 
	 * @param id de la recarga que se elimina
	 */
	public void eliminarRecarga(int id) {
		recargadao.delete(id);
	}
	
	/**
	 * Metodo que permite listar las recargas
	 * 
	 * @return Lista de todos las recargas
	 */
	public List<Recarga> listaRecargas() {
		return recargadao.getRecargas();
	}
	

}
