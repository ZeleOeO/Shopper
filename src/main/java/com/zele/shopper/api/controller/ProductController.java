package com.zele.shopper.api.controller;

import com.zele.shopper.api.dto.ProductDto;
import com.zele.shopper.exceptions.ProductNotFoundException;
import com.zele.shopper.service.product.ProductMapper;
import com.zele.shopper.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping("/all")
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        var product =  productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
        if (product == null) {return ResponseEntity.notFound().build();}

        return ResponseEntity.ok(productMapper.toDto(product));
    }
}
