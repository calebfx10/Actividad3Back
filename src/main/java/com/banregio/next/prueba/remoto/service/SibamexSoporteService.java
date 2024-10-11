package com.banregio.next.prueba.remoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.prueba.remoto.dto.CorreoPersona;
import com.banregio.next.prueba.remoto.dto.UsuarioSibamex;
import com.banregio.next.prueba.remoto.repository.SibamexSoporteRepository;
import com.banregio.next.base.feign.exception.NextFeignExceptionNoOpenCircuit;
import com.banregio.next.prueba.util.Constantes;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * En esta clase se espera tener lógica correspondiente al manejo de la respuesta al consumo de otros microservicios.
 * Cada método puede o no incluir un manejador de errores usando la anotacion {@link HystrixCommand}.
 * @author ${user}
 * @since ${date}
 */
@Service
public class SibamexSoporteService {

	@Autowired
	private SibamexSoporteRepository repo;
	
	/**
	 * La anotacion {@link HystrixCommand} permite configurar otro metodo a ejecutar si sucede una excepción.
	 * La excepción {@link NextFeignException} se dispara siempre que el otro microservicio haya generado un error,
	 * al ignorar dicha excepción estamos diciendo que no se ejecute el metodo "findByBrmFallback" cuando suceda.
	 * @param brm el o los parametros esperados.
	 * @return El modelo de datos.
	 */
	@HystrixCommand(fallbackMethod = "findByBrmFallback", ignoreExceptions = {NextFeignExceptionNoOpenCircuit.class})
	public UsuarioSibamex findByBrm(String brm) {
		List<UsuarioSibamex> users = repo.findByExample(brm, Constantes.TIPO_CONSULTA_C5);
		if(users!=null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * El metodo que será ejecutado si "findByBrm" falla y no es una excepción de tipo {@link NextFeignException}.
	 * Este metodo sirve para generar una respuesta alterna en caso de error.
	 * @param brm El mismo parametro que espera el metodo principal.
	 * @param e La excepción que fue generada.
	 * @return Un objeto del mismo tipo que el metodo principal.
	 */
	protected UsuarioSibamex findByBrmFallback(String brm, Throwable e) {
		return null;
	}
	
	
	public CorreoPersona consultaCorreos(CorreoPersona cp) {
		return repo.correospersonas(cp);
	}
	
	public UsuarioSibamex usuarioById() {
		return repo.usuarioById("1");
	}
}
