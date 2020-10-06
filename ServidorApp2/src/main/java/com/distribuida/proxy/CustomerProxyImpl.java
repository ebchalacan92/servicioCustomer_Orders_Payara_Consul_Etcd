package com.distribuida.proxy;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.prueba.entidad.Customer;

@ApplicationScoped				// A�adimos la siguiente anotaci�n para se�alar que esta clase es un complemento CDI de ambito de aplicaci�n.
public class CustomerProxyImpl{
		
	@Inject private CustomerProxy proxy; //Injectamos la dependencia para traer el m�todo buscatodos del servicio customer

	public List<Customer> obtenerCustomer(){
		return proxy.buscartodo();
	}
	
	
}
