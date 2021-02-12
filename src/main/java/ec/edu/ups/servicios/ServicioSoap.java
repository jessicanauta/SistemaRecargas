package ec.edu.ups.servicios;

import java.util.ArrayList;
import java.util.List;

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
	public void realizarRecarga(String numero, double saldo, String operadora) throws Exception {
		Recarga r = new Recarga();
		Telefono t = onTelefono.obtenerTelefono(numero);
		r.setTelefono(t);
		r.setOperadora(operadora);
		r.setSaldo(saldo);
		onRecarga.guardarRecarga(r);

		if (t.getSaldoAnterior() != 0) {
			t.setSaldoAnterior(t.getSaldoAnterior());
			t.setSaldo(saldo + t.getSaldoAnterior());
			onTelefono.actualizarTelefono(t);
		} else {
			t.setSaldoAnterior(t.getSaldo());
			t.setSaldo(saldo + t.getSaldoAnterior());
			onTelefono.actualizarTelefono(t);
		}
	}

	@WebMethod
	public void crearCliente(String cedula, String nombre, String apellido, String correo, String numero, double saldo,
			double saldoAnterior) throws Exception {
		Cliente c = new Cliente();
		Telefono t = new Telefono();
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
	
	@WebMethod
	public ArrayList getRecargas(){
		List datos=new ArrayList();
		List<Recarga> lstRecargas=onRecarga.listaRecargas();
		for (Recarga r : lstRecargas) {
			//datods cliente
			datos.add(r.getTelefono().getCliente().getCedula());
			datos.add(r.getTelefono().getCliente().getNombre());
			datos.add(r.getTelefono().getCliente().getApellido());
			datos.add(r.getTelefono().getNumero());
			datos.add(r.getTelefono().getSaldo());
			datos.add(r.getTelefono().getSaldoAnterior());
			
			//saldo de rla recarga
			datos.add(r.getOperadora());
			datos.add(r.getSaldo());
			
		}
		return  (ArrayList) datos;
	}

}
