package com.distribuida.proxy;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.prueba.entidad.Customer;

@ApplicationScoped				// Añadimos la siguiente anotación para señalar que esta clase es un complemento CDI de ambito de aplicación.
public class CustomerProxyImpl{
		
	@Inject private CustomerProxy proxy; //Injectamos la dependencia para traer el método buscatodos del servicio customer

	public List<Customer> obtenerCustomer(){
		return proxy.buscartodo();
	}
	
	
}
