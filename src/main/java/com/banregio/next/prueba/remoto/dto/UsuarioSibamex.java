package com.banregio.next.prueba.remoto.dto;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * Modelo de datos para intercambiar datos entre microservicios.
 * @author ${user}
 * @since ${date}
 */
@Getter
@Setter
public class UsuarioSibamex implements Serializable{
	private static final long serialVersionUID = -4762139167376781607L;
	private String numero;
	private String clave;
	private String status;
	private String activo;
	private String eMail;
	private String nombre;
}