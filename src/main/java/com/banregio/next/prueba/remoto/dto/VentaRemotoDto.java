package com.banregio.next.prueba.remoto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaRemotoDto {
	
	private Long idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;

}
