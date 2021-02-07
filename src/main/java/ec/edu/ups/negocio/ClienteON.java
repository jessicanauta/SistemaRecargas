package ec.edu.ups.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.controlador.ClienteDAO;
import ec.edu.ups.modelo.Cliente;

/**
 * Esta clase me permite hacer diferentes validaciones o metodos necesarios
 * antes de poder realizar las diferentes funciones basicas en la base de datos
 */

@Stateless
public class ClienteON {
	
	@Inject
	private ClienteDAO clientedao;
	
	public ClienteON() throws Exception {
		super();
	}
	
	/**
	 * Metodo que me permite guardar el cliente en la base de datos
	 * 
	 * @param c Cliente que se guarda en la base de datos
	 */
	public void guardarCliente(Cliente cliente) throws Exception {
		try {
			Cliente aux = clientedao.read(cliente.getCedula());

			if (aux != null) {
				clientedao.update(cliente);
			} else {
				clientedao.insert(cliente);
			}
//			clientedao.insert(cliente);
		} catch (Exception e) {
				throw new Exception("Error al ingresar Cliente");
		}
	}
	
	/**
	 * Metodo que permite la busqueda de un cliente
	 * 
	 * @param cedulaCliente Cedula del cliente que se busca
	 * @return Cliente obtenido de la busqueda
	 */
	public Cliente buscarCliente(String cedula) {
		return clientedao.read(cedula);
	}
	
	/**
	 * Metodo que permite actualizar un cliente
	 * 
	 * @param cliente Cliente que se actualiza
	 */
	public void actualizarCliente(Cliente cliente) throws Exception{
        try {
            clientedao.update(cliente);
        } catch (Exception e) {
        	throw new Exception("Error al actualizar Cliente");
        }
    }
	
	/**
	 * Metodo que permite eliminar un cliente
	 * 
	 * @param cedulaCliente Cedula del cliente que se elimina
	 */
	public void eliminarCliente(String cedulaCliente) {
		clientedao.delete(cedulaCliente);
	}
	
	/**
	 * Metodo que permite listar los clientes
	 * 
	 * @return Lista de todos los clientes
	 */
	public List<Cliente> listaClientes() {
		return clientedao.getClientes();
	}

}
