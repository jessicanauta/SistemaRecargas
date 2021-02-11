package ec.edu.ups.servicios;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ClienteON;
import ec.edu.ups.negocio.RecargaON;
import ec.edu.ups.negocio.TelefonoON;

@Path("comprar")
public class ServicioRest {

	@Inject
	RecargaON onRecarga;

	@Inject
	ClienteON onCliente;

	@Inject
	TelefonoON onTelefono;	
	
	@PUT
	@Consumes("application/json")
	@Path("crear/{cedula}/{nombre}/{apellido}/{correo}/{numero}/{saldo}/{saldoAnterior}")
	public void crearCliente(@PathParam("cedula")String cedula,@PathParam("nombre")String nombre, @PathParam("apellido")String apellido, @PathParam("correo")String correo,@PathParam("numero")String numero,@PathParam("saldo") double saldo,@PathParam("saldoAnterior")double saldoAnterior ) throws Exception {
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
