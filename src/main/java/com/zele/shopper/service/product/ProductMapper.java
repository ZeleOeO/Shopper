package com.zele.shopper.service.product;

import com.zele.shopper.api.dto.ProductDto;
import com.zele.shopper.entity.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductMapper {

    private final ModelMapper modelMapper;

    public ProductDto toDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
