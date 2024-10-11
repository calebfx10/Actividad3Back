package com.banregio.next.prueba.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.prueba.remoto.dto.VentaRemotoDto;
import com.banregio.next.prueba.remoto.service.VentaRemotoService;

@Service

public class RemotoVentaService {

	@Autowired
	private VentaRemotoService ventaRemotoService;
	
	public List<VentaRemotoDto> findProducto(){
		
		return ventaRemotoService. findProducto();
		
	}
	
}
