package com.zele.shopper.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zele.shopper.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ProductDto {
    private String name;
    private String brand;
    private Double price;
    private int quantity;
    private String description;
}

