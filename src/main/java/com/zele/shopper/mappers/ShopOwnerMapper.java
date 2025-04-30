package com.zele.shopper.mappers;

import com.zele.shopper.api.dto.ShopOwnerDto;
import com.zele.shopper.entity.ShopOwner;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface ShopOwnerMapper {
    ShopOwnerDto toDto(ShopOwner shopOwner);
}
