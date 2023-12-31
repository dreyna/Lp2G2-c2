package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="PRODUCTO")
public class ProductoEntity implements Serializable{

	private static final long serialVersionUID = -4694926099236184562L;

	@Id
  	@Column(name = "IDPRODUCTO")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProducto")
    @SequenceGenerator(sequenceName = "SEQ_PRODUCTO", allocationSize = 1, name = "seqProducto")
	private Long id;
  
  	@Column(name = "NOMBRE", nullable = false)
  	private String nombre;
  	
  	@Column(name = "PRECIO")
  	private double precio;

  	@Column(name = "CANTIDAD")
  	private int cantidad;

  	@Column(name = "ESTADO", nullable = false)
  	@Builder.Default
  	private char estado = '1';

  	@ManyToOne
    @JoinColumn(name = "IDCATEGORIA",  nullable = false)
    private CategoriaEntity categoria;
}