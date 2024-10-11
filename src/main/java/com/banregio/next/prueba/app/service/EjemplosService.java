package com.banregio.next.prueba.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.prueba.app.domain.entity.Ejemplo;
import com.banregio.next.prueba.app.exception.TestEjemploException;
import com.banregio.next.prueba.app.facade.EjemplosFacade;
import com.banregio.next.prueba.remoto.dto.CorreoPersona;
import com.banregio.next.prueba.remoto.dto.UsuarioSibamex;
import com.banregio.next.prueba.remoto.service.SibamexSoporteService;
import com.banregio.next.postgre.service.PostgreService;
import org.springframework.http.HttpStatus;
import com.banregio.next.prueba.util.EjemploError;

/**
 * Ejemplo de Servicio para un CRUD. 
 * @author ${user}
 * @since ${date}
 */
@Service
public class EjemplosService extends PostgreService<Ejemplo>{
	
	private SibamexSoporteService usuariosService; 

	@Autowired
	public EjemplosService(EjemplosFacade facade, SibamexSoporteService usuariosService) {
		super(facade);
		this.usuariosService = usuariosService;
	}
	
	@Override
	public List<Ejemplo> findAll() {
		return super.findAll();
		
	}
	
	@Override
	public Ejemplo findById(Long id) {
		usuariosService.consultaCorreos(new CorreoPersona());
		return super.findById(id);
	}
	
	public Ejemplo findUsuario(Long id, String brm){
		Ejemplo ejemplo = super.findById(id);
		UsuarioSibamex user = usuariosService.findByBrm(brm);
		if(null!=user) {
			throw new TestEjemploException(EjemploError.ERROR_DE_EJEMPLO, HttpStatus.OK);
		}
		ejemplo.setUsuario(user);
		return ejemplo;
	}
}