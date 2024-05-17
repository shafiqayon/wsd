package com.wsd.ayon.mapper;

import com.wsd.ayon.dtos.ProductDTO;
import com.wsd.ayon.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "sku", target = "productSku")
    ProductDTO toDto(Product product);


}
