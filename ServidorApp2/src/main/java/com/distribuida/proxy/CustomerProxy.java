package com.distribuida.proxy;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import com.prueba.entidad.Customer;

public interface CustomerProxy {
	
	@GET		//M�todo HTTP que permite en la clase Implementeaci�n guardar la cadena proxy que viene desde el m�todo buscartodos del servicio customer
	@Consumes(value = MediaType.APPLICATION_JSON)
	public List<Customer> buscartodo();
	
	
}
