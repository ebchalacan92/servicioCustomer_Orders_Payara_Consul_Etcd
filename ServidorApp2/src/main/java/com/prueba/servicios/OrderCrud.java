package com.prueba.servicios;

import java.util.List;

import com.prueba.entidad.Customer;
import com.prueba.entidad.Orders;

public interface OrderCrud {					//Servicio Pedidos, almacena los métodos para el CRUD

	public void Ingresar(Orders orders);		// Método insertar pedidos
	
	 public Orders Buscar(int id);				// Método buscar por id (devuelve un objeto)
	 
	 public void Actualizar(Orders orders);		// Método para actualizar pedidos
	 
	 public List<Orders> buscarTodo();			// Método Listar todos los datos
	 
	 public void Eliminar(int id);				// Método eliminar pedidos
	 
	 public  List<Orders> listarDatosCombinados(); // Método personalizado que lista datos de los pedidos y el cliente que realizo la compra
	 
	 public List<Customer> listarCustomer();	//Método replicado del servicio customer(listar todos los customer)
	 
	 public List<Orders> listarPorId(int id);	//Método que lista por id(devuelve una lista)
	
}
