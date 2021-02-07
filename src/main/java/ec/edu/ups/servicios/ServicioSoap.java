package ec.edu.ups.servicios;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Recarga;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ClienteON;
import ec.edu.ups.negocio.RecargaON;
import ec.edu.ups.negocio.TelefonoON;

@WebService
public class ServicioSoap {

	@Inject
	RecargaON onRecarga;

	@Inject
	ClienteON onCliente;

	@Inject
	TelefonoON onTelefono;

	@WebMethod
	public void realizarRecarga(String numero, double Saldo, String operadora) throws Exception {
//		Recarga r = new Recarga();
//		Telefono t = onTelefono.buscarTelefono(numero);
//		Cliente c = onCliente.buscarCliente(t.getCliente().getCedula());
//		t.setCliente(c);
//		r.setTelefono(t);
//		onRecarga.guardarRecarga(r);
	}

	@WebMethod
	public void crearCliente(String cedula,String nombre, String apellido, String correo,String numero, double saldo, double saldoAnterior ) throws Exception {
		Cliente c=new Cliente();
		Telefono t=new Telefono();
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setCedula(cedula);
		c.setCorreo(correo);
		onCliente.guardarCliente(c);

		t.setCliente(c);
		t.setNumero(numero);
		t.setSaldo(saldo);
		t.setSaldoAnterior(saldoAnterior);
		
		onTelefono.guardarTelefono(t);
		

	}

}
