package com.example.demo.controller.general;
import static com.example.demo.commons.GlobalConstants.API_PRODUCTO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.base.ResMessage;
import com.example.demo.controller.error.GenericError;
import com.example.demo.dto.ProductoDto;
import com.example.demo.service.general.service.ProductoService;

import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(API_PRODUCTO)
@Slf4j
public class ProductoController extends GenericError{

	@Autowired
	private ProductoService productoService;

	@GetMapping("/all")
	public ResponseEntity<?> listar() {
		try {
            List<ProductoDto> lsProducto =  productoService.findAll();
            if (isNull(lsProducto) || lsProducto.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok().body(lsProducto);
        } catch (Exception e) {
            log.info("Error: " + e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		try {
            if (id <= 0) {
                return ResponseEntity.badRequest().body("El id " + id + " no existe");
            }
            Optional<ProductoDto> productoDto = productoService.findById(id);
            if (productoDto.isPresent()) {
                return ResponseEntity.ok().body(productoDto);
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@PostMapping("/producto")
	  public ResponseEntity<?> createTutorial(@Validated @RequestBody ProductoDto productoDto, BindingResult result) {
		ResMessage resMessage = new ResMessage();
        try {
            if (result.hasErrors()) {
                return super.getError(result);
            }
            Boolean existProducto = productoService.existsByNombre(productoDto.getName());
            if (existProducto) {
                resMessage.setMessage("Ya existe un producto con este nombre: " + productoDto.getName());
                return new  ResponseEntity<Object>(resMessage, HttpStatus.FORBIDDEN);
            }
            productoService.ingreso(productoDto);
            resMessage.setMessage("Ingreso exitoso");
            resMessage.setSuccess(true);
            return ResponseEntity.status(HttpStatus.CREATED).body(resMessage);
        } catch (RuntimeException e) {
            log.error("e" + e.getMessage());
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	  }

	@PutMapping("/producto")
	  public ResponseEntity<?> updateProducto(@Validated @RequestBody ProductoDto productoDto, BindingResult result) {
		ResMessage resMessage = new ResMessage();
        try {
            if (result.hasErrors()) {
                return super.getError(result);
            }
            Optional<ProductoDto> editProducto = productoService.findById(productoDto.getId());
            if (editProducto.isEmpty()) {
                resMessage.setMessage("El producto con el id : " + productoDto.getId() + " no existe");
                return new  ResponseEntity<Object>(resMessage, HttpStatus.BAD_GATEWAY);
            } 
            ProductoDto producto = productoService.update(productoDto);
            if (isNull(producto)) {
                resMessage.setMessage("El producto con el id: " + productoDto.getId() + " ya se encuentra registrado en la base de datos");
                return new  ResponseEntity<Object>(resMessage, HttpStatus.BAD_GATEWAY);
            }
            resMessage.setMessage("Registro actualizado");
            resMessage.setSuccess(true);
            return ResponseEntity.ok().body(resMessage);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	  }
	@DeleteMapping("/producto/{id}")
	  public ResponseEntity<?> deleteProducto(@PathVariable("id") long id) {
		ResMessage resMessage = new ResMessage();
        try {
            log.info("id -> "+id);
            if (id <= 0) {
                resMessage.setMessage("El id " + " no existe");
                return ResponseEntity.badRequest().body(resMessage);
            }
            productoService.deleteLogic(id);
            resMessage.setMessage("Producto eliminado");
            resMessage.setSuccess(true);
            return ResponseEntity.ok().body(resMessage);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	  }

}
