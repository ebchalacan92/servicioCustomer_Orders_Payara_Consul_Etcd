package com.prueba.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.prueba.entidad.Orders;
import com.prueba.servicios.OrderCrud;

@Path("/orders")							// Identifica la ruta URI
@ApplicationScoped							// Añadimos la siguiente anotación para señalar que esta clase es un complemento CDI de ambito de aplicación.
public class OrderRest {

	@Inject
	private OrderCrud jdbc;
	
	
	@POST									// asigna al método HTTP POST.
	@Transactional							// Permite que el servicio puede hacer varias llamadas en una sola transacción sin cerrar la conexión entre llamadas
    @Path("/")
	@Produces(MediaType.APPLICATION_JSON)	// determina el tipo de contenido que devuleve el servidor
	@Consumes(MediaType.APPLICATION_JSON)	// Determina el tipo de contenido que consume un recurso del cliente
	public Response añadirOrder(Orders s) {
		
		jdbc.Ingresar(s);
		
		return Response.ok(s).build();
		
	}
	
	@PUT									// asigna al método HTTP PUT.
	@Transactional
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarOrders(Orders s) {
		
		jdbc.Actualizar(s);
		return Response.ok(s).build();
		
	}
	
	@GET									// asigna al método HTTP GET.(Buscar por id; devuelve objeto)
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response  buscar(@PathParam("id") int id) {
		Orders orders = jdbc.Buscar(id);
		if (orders != null) {
			return Response.status(Response.Status.OK).entity(orders).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("pedido no encontrado").build();

		}
	}
	
	@GET									// asigna al método HTTP GET.(Lista todos los datos de orders)
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Orders> buscartodo() {
		List<Orders> lista = jdbc.buscarTodo();
		return lista;
		
	}
	
	
	@DELETE									// asigna al método HTTP DELETE.
	@Transactional
    @Path("/{id}")
	public Response borrarOrder(@PathParam("id") int id) {
		String mensaje = "Order Eliminad0";
		Orders orders = jdbc.Buscar(id);
		
		jdbc.Eliminar(id);
		
		return Response.ok(mensaje).build();
	}
	
	@Path("/listar")
	@GET 										// asigna al método HTTP GET.(Lista los datos de orders y customers)
	@Produces(value = MediaType.APPLICATION_JSON) // determina el tipo de contenido que devuleve el servidor
	public List<Orders> listarDatosCombinados(){ // Método Listar todos los pedidos
		return jdbc.listarDatosCombinados();
	}
	
	@Path("listar/{id}")
	@GET 										// asigna al método HTTP GET. (Busca por id ; devuelve una lista )
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Orders> listarPorId(@PathParam("id") int id) { // Método de buscar pedidos por id
		return jdbc.listarPorId(id);
				
	}
	
	@GET
	@Path(value = "/ping")
	@Produces(MediaType.APPLICATION_JSON)
	public String hola() {
		
		System.out.println("ping");
		return "ok";
	}
}
