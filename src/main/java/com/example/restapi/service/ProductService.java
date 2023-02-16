package com.example.restapi.service;

import com.example.restapi.dto.ProductDto;

import java.util.List;

public interface ProductService {
  List<ProductDto> findAll();

  ProductDto findById(Long id);

  ProductDto create(ProductDto productDto);

  ProductDto update(ProductDto productDto, Long id);

  boolean delete(Long id);
}
