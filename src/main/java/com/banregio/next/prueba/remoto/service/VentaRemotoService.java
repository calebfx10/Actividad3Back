package com.banregio.next.prueba.remoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.base.exception.NextError500;
import com.banregio.next.base.feign.exception.NextFeignExceptionNoOpenCircuit;
import com.banregio.next.prueba.remoto.dto.VentaRemotoDto;
import com.banregio.next.prueba.remoto.repository.RemotoVentaRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VentaRemotoService {
	@Autowired
	private RemotoVentaRepository productoRemotoService;
	
	
	@HystrixCommand(fallbackMethod = "callFindProductoFallback",	ignoreExceptions = { NextFeignExceptionNoOpenCircuit.class })
	public List<VentaRemotoDto> findProducto()
	{
		return productoRemotoService.findProducto();
	}
	
	protected List<VentaRemotoDto> callFindProductoFallback(Throwable e) {

		log.error("callFindProductoFallback error al buscar Producto",e);
		throw new NextError500(e.getCause() != null ? e.getCause().getMessage() : e.getMessage());
	}

}
