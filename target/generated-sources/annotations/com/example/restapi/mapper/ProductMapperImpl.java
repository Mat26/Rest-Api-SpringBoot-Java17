package com.example.restapi.mapper;

import com.example.restapi.dto.ProductDto;
import com.example.restapi.model.Product;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-16T10:50:39-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product ProductDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setTitle( productDto.title() );
        product.setDescription( productDto.description() );
        product.setExpirationDate( productDto.expirationDate() );
        product.setPrice( productDto.price() );

        return product;
    }

    @Override
    public ProductDto ProductToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        String title = null;
        String description = null;
        LocalDateTime expirationDate = null;
        int price = 0;

        title = product.getTitle();
        description = product.getDescription();
        expirationDate = product.getExpirationDate();
        price = product.getPrice();

        ProductDto productDto = new ProductDto( title, description, expirationDate, price );

        return productDto;
    }
}
