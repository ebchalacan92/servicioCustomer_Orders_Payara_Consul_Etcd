package com.prueba.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.distribuida.proxy.CustomerProxyImpl;
import com.prueba.entidad.Customer;
import com.prueba.entidad.Orders;

@ApplicationScoped

//SEGUNDA FORMA DE MANEJADOR EL POOL DE CONEXIONES USANDO EL MPCONFIG, LA SEGUNDA ES POR MEDIO DEL ARCHIVO WEB.XML
/*
 * @DataSourceDefinition(name = "java:app/microprofile/employees", className =
 * "${MPCONFIG=mysql.driver}", serverName = "${MPCONFIG=mysql.server}",
 * portNumber = 3306, user = "${MPCONFIG=mysql.user}", password =
 * "${MPCONFIG=mysql.password}", databaseName = "${MPCONFIG=mysql.database}",
 * properties = { "useSSL=false",
 * "requireSSL=true","serverTimezone=UTC","allowPublicKeyRetrieval=true" })
 */
public class OrderCrudImpl implements OrderCrud {
	
	@Inject										//Injectamos la clase Entity Manager para obtener los métodos del CRUD de JPA
	private CustomerProxyImpl servicioCliente;
	@Inject
	private EntityManager em;

	@Override
	public void Ingresar(Orders orders) {		//Método que implementa el ingreso de datos(orders)
		em.persist(orders);
		
	}

	@Override
	public Orders Buscar(int id) {				//Método que implementa el buscar por id(devuelve un objeto)
		Orders order = em.find(Orders.class, id);
		return order;
	}

	@Override
	public List<Orders> buscarTodo() {			//Método que implementa el buscar todos los datos
		TypedQuery<Orders> query = em.createQuery("Select e from Orders e", Orders.class);
		List<Orders> albums = query.getResultList();

		return albums;

	}

	@Override
	public void Actualizar(Orders orders) {		//Método que implementa la actualizacion de datos(orders)
		em.merge(orders);
	}

	@Override
	public void Eliminar(int id) {				//Método que implementa el eliminar datos(orders)
		Orders orders = em.find(Orders.class, id);
		em.remove(orders);
	}

	@Override
	public List<Customer> listarCustomer() {	//Método que lista todos los customers
		return servicioCliente.obtenerCustomer();
	}

	@Override
	public List<Orders> listarDatosCombinados() {	//Método personalozado que recorre la lista de customer y pedidos encontrando una semejanza en sus id's y genera una lista nueva de pedidos y el cliente que adquirio los productos
		List<Orders> listaPedidos = buscarTodo();
		List<Customer> listaCustomer = listarCustomer();
		List<Orders> lista = new ArrayList<>();
		for (Orders pedidos : listaPedidos) {
			for (Customer customer : listaCustomer) {
				if (pedidos.getCustomerId() == customer.getCustomer_id()) {
					pedidos.datosCustomer = (customer.getName() + " " + customer.getSurname());
					lista.add(pedidos);
				}
			}
		}
		return lista;
	}

	@Override
	public List<Orders> listarPorId(int id) {	//Método personalizado que implementa el listar por id(devuelve una lista)
		List<Orders> listaPedidos = listarDatosCombinados();
		List<Orders> lista = new ArrayList<>();
		for (Orders pedidos : listaPedidos) {
			if (pedidos.getOrder_id().equals(id)) {
				System.out.println(id + "," + pedidos.getOrder_id());
				lista.add(pedidos);
			} else {
				System.out.println("vacio");
			}
		}
		return lista;
	}

}
