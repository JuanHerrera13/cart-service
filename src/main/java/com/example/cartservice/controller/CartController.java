package com.example.cartservice.controller;

import com.example.cartservice.domain.Cart;
import com.example.cartservice.dto.mapping.CartMapper;
import com.example.cartservice.service.impl.CartServiceImpl;
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
public class CartController extends RootController {

    private final CartServiceImpl cartServiceImpl;
    private final CartMapper cartMapper;

    @GetMapping(path = "/carts")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> fetchAllCarts() {
        return cartServiceImpl.findAllCarts();
    }

    @GetMapping(path = "/carts/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public CartDto findCartById(@PathVariable String cartId) {
        final Cart cart = cartServiceImpl.findCartById(cartId);
        return cartMapper.cartToCartDto(cart);
    }

    @PostMapping(path = "/carts/cart.add")
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto addCart(@Valid @RequestBody CartCreationDto cartCreationDto) {
        return cartServiceImpl.addCart(cartCreationDto);
    }

    @DeleteMapping(path = "/carts/{cartId}/cart.delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCart(@PathVariable String cartId) {
        cartServiceImpl.deleteCart(cartId);
    }

    @PostMapping(path = "/carts/{cartId}/cart.books.add")
    @ResponseStatus(HttpStatus.OK)
    public CartDto addUserBooks(@PathVariable String cartId, @Valid @RequestBody CartBookListDto cartBookListDto) {
        return cartServiceImpl.addBook(cartId, cartBookListDto);
    }

    @PostMapping(path = "/carts/{cartId}/cart.books.remove")
    @ResponseStatus(HttpStatus.OK)
    public CartDto removeUserBooks(@PathVariable String cartId, @Valid @RequestBody CartBookListDto cartBookListDto) {
        return cartServiceImpl.removeBook(cartId, cartBookListDto);
    }
}
