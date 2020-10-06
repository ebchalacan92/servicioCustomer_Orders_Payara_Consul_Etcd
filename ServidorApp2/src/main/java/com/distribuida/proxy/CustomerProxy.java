package com.distribuida.proxy;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import com.prueba.entidad.Customer;

public interface CustomerProxy {
	
	@GET		//Método HTTP que permite en la clase Implementeación guardar la cadena proxy que viene desde el método buscartodos del servicio customer
	@Consumes(value = MediaType.APPLICATION_JSON)
	public List<Customer> buscartodo();
	
	
}
