package com.example.cartservice.controller;

import com.example.cartservice.Service.impl.CartServiceImpl;
import com.example.cartservice.dto.CartBookListDto;
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

    private final CartServiceImpl cartServiceImpl;

    @PostMapping(path = "/carts/cart.add")
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto addCart(@Valid @RequestBody CartCreationDto cartCreationDto) {
        return cartServiceImpl.addCart(cartCreationDto);
    }

    @GetMapping(path = "/carts")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> fetchAllCarts() {
        return cartServiceImpl.findAllCarts();
    }
    @PostMapping(path = "/carts/{cartId}/cart.books.add")
    @ResponseStatus(HttpStatus.OK)
    public CartDto addUserBooks(@PathVariable String cartId, @Valid @RequestBody CartBookListDto cartBookListDto) {
        return cartServiceImpl.addBook(cartId, cartBookListDto);
    }
    @DeleteMapping(path = "/carts/{cartId}/cart.books.remove")
    @ResponseStatus(HttpStatus.OK)
    public CartDto removeUserBooks(@PathVariable String cartId, @Valid @RequestBody CartBookListDto cartBookListDto) {
        return cartServiceImpl.removeBook(cartId, cartBookListDto);
    }
}
