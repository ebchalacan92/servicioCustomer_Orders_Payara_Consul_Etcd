package com.prueba.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity					// La anotación define que mi clase se puede asignar a la tabla orders
@Table(name="orders")	// indicamos la tabla contra la que mapea la entidad y colocamos el nombre real de la tabla en mi BDD
public class Orders implements Serializable{	// conversion de un objeto java en un flujo estatico de bytes

	private static final long serialVersionUID = 1L;	// número de version de la clase
	
	@Id									// Identidificador de la clase Customer que usa el entity manager para persistir el objeto
	@Column(name = "orders_id")			// Toma el nombre id de la columna de la tabla customer para poder mapear.
	private Integer order_id;
	
	@Column(name="item")
    private String item;

	@Column(name="price")
    private Double price;

	@Column(name="customer_id")
    private Integer customerId;

	@Transient							//No toma en cuenta a la hora de la persistencia en los datoss, pero sirve para recolectar un conjunto de datos personalizado
	public String datosCustomer;
    
	
	//Gets y Sets 
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getDatosCustomer() {
		return datosCustomer;
	}

	public void setDatosCustomer(String datosCustomer) {
		this.datosCustomer = datosCustomer;
	}
	
	
    
    
}
