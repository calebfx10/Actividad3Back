package com.banregio.next.prueba.app.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * Los modelos de este paquete son usados para los controllers que no necesariamente son cruds  
 * @author ${user}
 * @since ${date}
 */
@Getter
@Setter
@ApiModel(description = "Modelo de datos para el servicio de ejemplos")
public class EjemploModel{
	@ApiModelProperty(value = "Campo que sirve para guardar la propiedad 1")
	private String propiedad1;
	
	@ApiModelProperty(value = "Campo que sirve para guardar la propiedad 2")
	private String propiedad2;
	
	@ApiModelProperty(value = "Campo que sirve para guardar la propiedad 3")
	private String propiedad3;

}