package com.zele.shopper.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zele.shopper.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopOwnerDto {
    private String username;
    private String email;
    private List<Product> product;
}
