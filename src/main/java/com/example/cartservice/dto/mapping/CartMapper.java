package com.example.cartservice.dto.mapping;

import com.example.cartservice.Domain.Cart;
import com.example.cartservice.dto.CartCreationDto;
import com.example.cartservice.dto.CartDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CartMapper {

    Cart cartCreationDtoToCart(CartCreationDto cartCreationDto);

    CartDto cartToCartDto(Cart cart);

    List<CartDto> cartListToCartListDto(List<Cart> carts);
}
