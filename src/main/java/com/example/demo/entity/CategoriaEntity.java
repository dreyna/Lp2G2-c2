package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CATEGORIA")
public class CategoriaEntity {

	@Id
  	@Column(name = "IDCATEGORIA")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCategoria")
    @SequenceGenerator(sequenceName = "SEQ_CATEGORIA", allocationSize = 1, name = "seqCategoria")
	private Long id;  
  	@Column(name = "NOMBRE", nullable = false)
  	private String nombre;  	
  	@Column(name = "ESTADO", nullable = false)
  	private char estado = '1';
  	
  	@OneToMany(mappedBy = "categoria", cascade = CascadeType.MERGE)
    @ToString.Exclude
    List<ProductoEntity> producto;
  	
}
