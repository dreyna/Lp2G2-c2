package com.example.demo.service.general.service;

import org.hibernate.service.spi.ServiceException;

import com.example.demo.dto.ProductoDto;
import com.example.demo.service.base.GenericService;

public interface ProductoService extends GenericService<ProductoDto>{
	boolean existsByNombre(String nombre) throws ServiceException;
	void ingreso(ProductoDto productoDto) throws ServiceException;
}
