package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ProductoEntity create(ProductoEntity prod) {
		// TODO Auto-generated method stub
		return productoRepository.save(prod);
	}

	@Override
	public List<ProductoEntity> readAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public ProductoEntity update(ProductoEntity prod) {
		// TODO Auto-generated method stub
		return productoRepository.save(prod);
	}

	@Override
	public void delete(Long id) {
		productoRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoEntity read(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

}
