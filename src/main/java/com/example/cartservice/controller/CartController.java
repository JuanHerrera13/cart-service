package com.example.cartservice.controller;

import com.example.cartservice.Service.impl.CartServiceImpl;
import com.example.cartservice.dto.CartCreationDto;
import com.example.cartservice.dto.CartDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController extends RootController{

    private final CartServiceImpl cartService;
    @PostMapping(path = "/carts/cart.add")
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto addCart(@Valid @RequestBody CartCreationDto cartCreationDto) {
        return cartService.addCart(cartCreationDto);
    }

    @GetMapping(path = "/carts")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> fetchAllCarts() {
        return cartService.findAllCarts();
    }
}
