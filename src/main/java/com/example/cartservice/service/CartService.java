package com.example.cartservice.service;

import com.example.cartservice.domain.Cart;
import com.example.cartservice.dto.CartBookListDto;
import com.example.cartservice.dto.CartCreationDto;
import com.example.cartservice.dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    Cart findCartById(String id);

    CartDto addCart(CartCreationDto cartCreationDto);
    List<CartDto> findAllCarts();

    CartDto addBook(String cartId, CartBookListDto cartBookListDto);

    CartDto removeBook(String cartId, CartBookListDto cartBookListDto);

    void deleteCart(String cartId);
}
