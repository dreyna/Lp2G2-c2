package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.ProductoEntity;


public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>, JpaSpecificationExecutor<ProductoEntity>{
	 boolean existsByNombre(String nombre);

}