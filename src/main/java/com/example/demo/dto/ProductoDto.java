package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDto {
	
	private long id;	
	@NotBlank(message = "Nombre es requerido")
  	private String name;  	
  	private String description;
  	@NotBlank(message = "El valor del precio es requerido.")
  	private double pricing;
  	@NotBlank(message = "El valor del stock es requerido.")
  	private double stock;
  	private char status;
  	private int cat;
  	@Valid
  	private CategoriaDto cate;
  	
}
