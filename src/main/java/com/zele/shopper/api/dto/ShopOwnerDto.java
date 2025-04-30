package com.zele.shopper.api.dto;

import com.zele.shopper.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ShopOwnerDto {
    private String username;
    private String email;
    private List<Product> product;
}
