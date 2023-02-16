package com.example.restapi.controller;

import com.example.restapi.dto.ProductDto;
import com.example.restapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  private ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<ProductDto> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public ProductDto findById(@PathVariable long id) {
    return productService.findById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ProductDto create(@Valid @RequestBody ProductDto productDto) {
    return productService.create(productDto);
  }


  @PutMapping("/{id}")
  public ProductDto update(@RequestBody ProductDto productDto, @PathVariable Long id) {
    return productService.update(productDto, id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }


}
