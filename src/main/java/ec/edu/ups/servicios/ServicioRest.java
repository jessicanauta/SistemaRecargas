package ec.edu.ups.servicios;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ClienteON;
import ec.edu.ups.negocio.RecargaON;
import ec.edu.ups.negocio.TelefonoON;

@Path("/comprar")
public class ServicioRest {

	@Inject
	RecargaON onRecarga;

	@Inject
	ClienteON onCliente;

	@Inject
	TelefonoON onTelefono;	
	
	@GET
	@Consumes("application/json")
	@Path("/crear")
	public void crearCliente(@QueryParam("cedula")String cedula,@QueryParam("nombre")String nombre, @QueryParam("apellido")String apellido, @QueryParam("correo")String correo,@QueryParam("numero")String numero,@QueryParam("saldo") double saldo,@QueryParam("saldoAnterior")double saldoAnterior ) throws Exception {
		Cliente c=new Cliente();
		Telefono t=new Telefono();
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
