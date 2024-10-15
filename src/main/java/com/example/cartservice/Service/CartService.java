package com.example.cartservice.Service;


import com.example.cartservice.dto.CartCreationDto;
import com.example.cartservice.dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    CartDto addCart(CartCreationDto cartCreationDto);
    List<CartDto> findAllCarts();
}
