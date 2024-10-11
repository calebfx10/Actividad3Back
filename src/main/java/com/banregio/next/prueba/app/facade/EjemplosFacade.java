package com.banregio.next.prueba.app.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.banregio.next.prueba.app.domain.entity.Ejemplo;
import com.banregio.next.prueba.app.domain.repository.EjemplosRepository;
import com.banregio.next.postgre.facade.PostgreFacade;

/**
 * Ejemplo de Facade para un CRUD.
 * Aquí se maneja la transaccionalidad.
 * @author ${user}
 * @since ${date}
 */
@Component
@Transactional(readOnly = true)
public class EjemplosFacade extends PostgreFacade<Ejemplo> {

	@Autowired
	public EjemplosFacade(EjemplosRepository repository) {
		super(repository);
	}
	
}
