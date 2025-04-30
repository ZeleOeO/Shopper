package com.zele.shopper.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShopOwnerNotFoundException extends RuntimeException {
    public ShopOwnerNotFoundException(String message) {super(message);}
}
