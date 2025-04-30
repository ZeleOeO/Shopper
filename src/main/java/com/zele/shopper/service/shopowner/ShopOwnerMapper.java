package com.zele.shopper.service.shopowner;

import com.zele.shopper.api.dto.ShopOwnerDto;
import com.zele.shopper.entity.ShopOwner;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ShopOwnerMapper {
    private final ModelMapper modelMapper;

    public ShopOwnerDto toDto(ShopOwner entity) {
        return modelMapper.map(entity, ShopOwnerDto.class);
    }
}