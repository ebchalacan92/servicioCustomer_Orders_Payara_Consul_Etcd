package com.prueba.servicios;

import java.util.List;

import com.prueba.entidad.Customer;
import com.prueba.entidad.Orders;

public interface OrderCrud {					//Servicio Pedidos, almacena los m�todos para el CRUD

	public void Ingresar(Orders orders);		// M�todo insertar pedidos
	
	 public Orders Buscar(int id);				// M�todo buscar por id (devuelve un objeto)
	 
	 public void Actualizar(Orders orders);		// M�todo para actualizar pedidos
	 
	 public List<Orders> buscarTodo();			// M�todo Listar todos los datos
	 
	 public void Eliminar(int id);				// M�todo eliminar pedidos
	 
	 public  List<Orders> listarDatosCombinados(); // M�todo personalizado que lista datos de los pedidos y el cliente que realizo la compra
	 
	 public List<Customer> listarCustomer();	//M�todo replicado del servicio customer(listar todos los customer)
	 
	 public List<Orders> listarPorId(int id);	//M�todo que lista por id(devuelve una lista)
	
}
