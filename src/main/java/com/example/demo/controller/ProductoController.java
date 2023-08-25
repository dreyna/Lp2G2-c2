package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.commons.GlobalConstants.API_PRODUCTO;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping(API_PRODUCTO)
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/all")
	public List<ProductoEntity> listar() {
		return productoService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductoEntity> listar2(@PathVariable("id") long id) {
		ProductoEntity prod = productoService.read(id);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/producto")
	  public ResponseEntity<ProductoEntity> createTutorial(@RequestBody ProductoEntity p) {
	    try {
	      ProductoEntity prod = productoService.create(new ProductoEntity(p.getId(), p.getNombre(), p.getDescripcion(),p.getPrecio(), p.getStock(), p.getEstado()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/prod/{id}")
	  public ResponseEntity<ProductoEntity> updateTutorial(@PathVariable("id") long id, @RequestBody ProductoEntity prod) {
	    ProductoEntity producto = productoService.read(id);

	    if (producto!=null) {
	      producto.setId(prod.getId());
	      producto.setNombre(prod.getNombre());
	      producto.setDescripcion(prod.getDescripcion());
	      producto.setPrecio(prod.getPrecio());
	      producto.setStock(prod.getStock());
	      producto.setEstado(prod.getEstado());
	      return new ResponseEntity<>(productoService.create(producto), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/producto/{id}")
	  public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") long id) {
	    try {
	      productoService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
