package com.example.demo.mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.demo.dto.ProductoDto;
import com.example.demo.entity.ProductoEntity;
@Mapper(componentModel = "spring", uses = { CategoriaMapper.class})
public interface ProductoMapper {
	@Mappings({
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "precio", target = "pricing"),
        @Mapping(source = "cantidad", target = "stock"),
        @Mapping(source = "estado", target = "status"),
        @Mapping(source = "categoria", target = "cate")
	})
	ProductoDto toProductoDto(ProductoEntity producto);
	@InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    ProductoEntity toProductoEntity(ProductoDto productoDto);
}
