package com.example.demo.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.example.demo.dto.CategoriaDto;
import com.example.demo.entity.CategoriaEntity;

@Mapper(componentModel = "spring", uses = { ProductoMapper.class})
public interface CategoriaMapper {
	@Mappings({
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "estado", target = "status")
	})
	CategoriaDto toCategoriaDto(CategoriaEntity categoria);
	@InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    CategoriaEntity toCategoriaEntity(CategoriaDto categoriaDto);
}
