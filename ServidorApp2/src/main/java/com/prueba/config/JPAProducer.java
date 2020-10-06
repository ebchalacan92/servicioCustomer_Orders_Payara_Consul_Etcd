package com.prueba.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped					// A�adimos la siguiente anotaci�n para se�alar que esta clase es un complemento CDI de ambito de aplicaci�n.
public class JPAProducer {

    @PersistenceContext				// El contenedor inyectar� de forma autom�tica una referencia v�lida del EntityManager creado a partir de la Persistence Unit
    @Produces						// M�todo Productor(no es creado por nosotros)
    private EntityManager em;	
}
