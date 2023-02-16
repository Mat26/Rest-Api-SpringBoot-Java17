package com.example.restapi.service;

import com.example.restapi.dto.ProductDto;
import com.example.restapi.mapper.ProductMapper;
import com.example.restapi.model.Product;
import com.example.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  private ProductMapper mapper;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository,ProductMapper mapper) {
    this.productRepository = productRepository;
    this.mapper = mapper;
  }

  @Override
  public List<ProductDto> findAll() {
    List<Product> products = (List<Product>) productRepository.findAll();
    return products.stream()
        .map(mapper::ProductToProductDto)
        .toList();
  }

  @Override
  public ProductDto findById(Long id) {
    return productRepository.findById(id)
        .map(mapper::ProductToProductDto)
        .orElseThrow(NullPointerException::new);
  }

  @Override
  public ProductDto create(ProductDto productDto) {
    Product product = mapper.ProductDtoToProduct(productDto);
    var productSaved = productRepository.save(product);
    return mapper.ProductToProductDto(productSaved);
  }

  @Override
  public ProductDto update(ProductDto productDto, Long id) {
    Product existingProduct = productRepository.findById(id)
        .orElseThrow(NullPointerException::new);
    existingProduct.setTitle(productDto.title());
    existingProduct.setDescription(productDto.description());
    existingProduct.setExpirationDate(productDto.expirationDate());
    existingProduct.setPrice(productDto.price());
    return mapper.ProductToProductDto(productRepository.save(existingProduct));
  }

  @Override
  public boolean delete(Long id) {
    productRepository.deleteById(id);
    return true;
  }
}
