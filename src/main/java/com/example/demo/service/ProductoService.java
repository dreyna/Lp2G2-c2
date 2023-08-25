package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductoEntity;

public interface ProductoService{
	ProductoEntity create(ProductoEntity prod);
	ProductoEntity update(ProductoEntity prod);
	void delete(Long id);
	ProductoEntity read(Long id);
	List<ProductoEntity> readAll();

}
