package com.example.demo.service.general.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductoDto;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.mapper.ProductoMapper;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.exeption.ServiceException;
import com.example.demo.service.exeption.ServiceSqlException;
import com.example.demo.service.general.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
    private ProductoRepository productoRepository;
	
	@Autowired
    private ProductoMapper productoMapper;

	@Override
	public List<ProductoDto> findAll() throws ServiceException, ServiceSqlException {
		// TODO Auto-generated method stub
		try {
            List<ProductoEntity> lsProducto = productoRepository.findAll();

            return lsProducto.stream().filter(ls-> ls.getEstado() == '1')
                    .map(ls -> productoMapper.toProductoDto(ls)).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new ServiceException(e);
        }
	}

	@Override
	public Optional<ProductoDto> findById(long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDto> findByObject(ProductoDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDto save(ProductoDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDto update(ProductoDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLogic(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsByNombre(String nombre) throws ServiceException {
		// TODO Auto-generated method stub
		try {
            return productoRepository.existsByNombre(nombre);
        } catch (RuntimeException e) {
            throw new ServiceException(e);
        }
	}

	@Override
	public void ingreso(ProductoDto productoDto) throws org.hibernate.service.spi.ServiceException {
		// TODO Auto-generated method stub
		
	}



}
