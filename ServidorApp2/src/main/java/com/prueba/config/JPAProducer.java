package com.prueba.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped					// Añadimos la siguiente anotación para señalar que esta clase es un complemento CDI de ambito de aplicación.
public class JPAProducer {

    @PersistenceContext				// El contenedor inyectará de forma automática una referencia válida del EntityManager creado a partir de la Persistence Unit
    @Produces						// Método Productor(no es creado por nosotros)
    private EntityManager em;	
}
