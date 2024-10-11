package com.banregio.next.prueba.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banregio.next.prueba.app.service.RemotoVentaService;
import com.banregio.next.prueba.remoto.dto.VentaRemotoDto;
import com.banregio.next.prueba.remoto.service.VentaRemotoService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/remoto-venta")

public class RemotoVentaController {
	@Autowired
	private RemotoVentaService ProductoRemotoService;
	
	@ApiOperation(value = "Buscar todaos los Productos remotos", notes = "Devuelve un listado de todos los registros.")
	@GetMapping(value = "/")
	public List<VentaRemotoDto> findAllProducto() {
		return ProductoRemotoService.findProducto();
	}
}
