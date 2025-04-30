package com.zele.shopper.api.controller;

import com.zele.shopper.api.dto.ShopOwnerDto;
import com.zele.shopper.exceptions.ShopOwnerNotFoundException;
import com.zele.shopper.repository.ShopOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopowner")
public class ShopOwnerController {
    private final ShopOwnerRepository ownerRepository;

    @Autowired
    public ShopOwnerController(ShopOwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/all")
    public List<ShopOwnerDto> getAllShopOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(user -> new ShopOwnerDto(user.getUsername(), user.getEmail(), user.getProduct()))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopOwnerDto> getShopOwnerById(@PathVariable Long id ) {
        var user = ownerRepository.findById(id).orElseThrow(() -> new ShopOwnerNotFoundException("ShopOwner not found"));
        if(user == null) {ResponseEntity.notFound().build();}
        var userDto = new ShopOwnerDto(user.getUsername(), user.getEmail(), user.getProduct());
        return ResponseEntity.ok(userDto);
    }

}
