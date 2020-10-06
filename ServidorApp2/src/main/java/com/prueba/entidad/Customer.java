package com.prueba.entidad;

public class Customer{
	//Objeto customer que permite la recepeción de datos provenientes provenientes del servicio customer. 
	//Las variables deben estar con el mismo nombre de la entidad customer del servicio customer.
	private Integer customer_id;
	private String name;
    private String surname;

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
