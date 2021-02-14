package ec.edu.ups.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.controlador.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;

/**
 * Esta clase me permite hacer diferentes validaciones o metodos necesarios
 * antes de poder realizar las diferentes funciones basicas en la base de datos
 */

@Stateless
public class TelefonoON {
	
	@Inject
	private TelefonoDAO telefonodao;

	public TelefonoON() throws Exception{
		super();
	}
	
	/**
	 * Metodo que me permite guardar el telefono en la base de datos
	 * 
	 * @param telefono Telefono que se guarda en la base de datos
	 */
	public void guardarTelefono(Telefono telefono) throws Exception {
		try {
			telefonodao.insert(telefono);
		} catch (Exception e) {
				throw new Exception("Error al ingresar el Telefono");
		}
	}
	
	/**
	 * Metodo que permite la busqueda de un telefono
	 * 
	 * @param id del telefono que se busca
	 * @return Telefono obtenido de la busqueda
	 */
	public Telefono buscarTelefono(int id) {
		return telefonodao.read(id);
	}
	
	/**
	 * Metodo que permite actualizar un telefono
	 * 
	 * @param telefono Telefono que se actualiza
	 */
	public Telefono obtenerTelefono(String numero) throws Exception{
        try {
        	return telefonodao.obtenerTelefono(numero);
        } catch (Exception e) {
        	throw new Exception("Error al obtener Telefono");
        }
    }
	
	public Telefono buscarTelefono(String numero) throws Exception{
        try {
        	return telefonodao.buscar(numero);
        } catch (Exception e) {
        	throw new Exception("Error al buscar el Telefono");
        }
    }
	
	
	/**
	 * Metodo que permite actualizar un telefono
	 * 
	 * @param telefono Telefono que se actualiza
	 */
	public void actualizarTelefono(Telefono telefono) throws Exception{
        try {
        	telefonodao.update(telefono);
        } catch (Exception e) {
        	throw new Exception("Error al actualizar Telefono");
        }
    }
	
	/**
	 * Metodo que permite eliminar un telefono
	 * 
	 * @param id del telefono que se elimina
	 */
	public void eliminarTelefono(int id) {
		telefonodao.delete(id);
	}
	
	/**
	 * Metodo que permite listar los telefonos
	 * 
	 * @return Lista de todos los telefonos
	 */
	public List<Telefono> listaTelefonos() {
		return telefonodao.getTelefonos();
	}
	

}
