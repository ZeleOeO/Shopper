package com.zele.shopper.api.controller;

import com.zele.shopper.api.dto.ShopOwnerDto;
import com.zele.shopper.exceptions.ShopOwnerNotFoundException;
import com.zele.shopper.repository.ShopOwnerRepository;
import com.zele.shopper.service.shopowner.ShopOwnerMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopowner")
@AllArgsConstructor
public class ShopOwnerController {
    private final ShopOwnerRepository ownerRepository;
    private final ShopOwnerMapper ownerMapper;

    @GetMapping("/all")
    public List<ShopOwnerDto> getAllShopOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(ownerMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopOwnerDto> getShopOwnerById(@PathVariable Long id ) {
        var user = ownerRepository.findById(id).orElseThrow(() -> new ShopOwnerNotFoundException("ShopOwner not found"));
        if(user == null) {ResponseEntity.notFound().build();}
        return ResponseEntity.ok(ownerMapper.toDto(user));
    }

}
