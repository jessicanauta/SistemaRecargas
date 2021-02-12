package ec.edu.ups.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Recarga;
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

	
	@GET
	@Consumes("application/json")
	@Path("/recarga")
	public void realizarRecarga(@QueryParam("numero")String numero, @QueryParam("saldo")double saldo, @QueryParam("operadora")String operadora) throws Exception {
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
	
	
	@GET
	@Consumes("application/json")
	@Path("/reporteMensual")
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
			System.out.println(""+datos);
		
		}
		return  (ArrayList) datos;
	}

}
