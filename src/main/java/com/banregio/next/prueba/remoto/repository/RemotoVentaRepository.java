package com.banregio.next.prueba.remoto.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.banregio.next.prueba.remoto.dto.VentaRemotoDto;


@FeignClient("${venta.uri}")
public interface RemotoVentaRepository {
	@GetMapping(value = "/api/producto")
	List<VentaRemotoDto> findProducto();
}
