package com.zele.shopper.mappers;

import com.zele.shopper.api.dto.ProductDto;
import com.zele.shopper.entity.Product;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
}
