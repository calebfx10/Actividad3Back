package com.banregio.next.prueba.remoto.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banregio.next.prueba.remoto.dto.CorreoPersona;
import com.banregio.next.prueba.remoto.dto.UsuarioSibamex;

/**
 * Interface que nos permite conectar con otros microservicios, usando solo configuración.
 * La url se conforma del valor de {@link FeignClient} mas el valor de {@link RequestMapping} 
 * @author ${user}
 * @since ${date}
 */
@FeignClient("${sibamex-soporte.uri}")
public interface SibamexSoporteRepository {

	@GetMapping(value = "/soporte/usuarios", params = { "tipoConsulta" })
	List<UsuarioSibamex> findByExample(@RequestParam("clave")  String clave,
			@RequestParam("tipoConsulta") String tipoConsulta);
	
	@PostMapping(value = "/correospersonas")
	CorreoPersona correospersonas(@RequestBody CorreoPersona body);
	
	@GetMapping(value = "/soporte/usuarios/{numero}")
	UsuarioSibamex usuarioById(@PathVariable("numero") String numero);
}
