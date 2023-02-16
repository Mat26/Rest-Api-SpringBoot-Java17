package com.example.restapi.mapper;

import com.example.restapi.dto.ProductDto;
import com.example.restapi.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  Product ProductDtoToProduct(ProductDto productDto);

  ProductDto ProductToProductDto(Product product);


}
