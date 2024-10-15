package com.example.cartservice.Service.impl;


import com.example.cartservice.Domain.Cart;
import com.example.cartservice.Service.CartService;
import com.example.cartservice.dto.CartCreationDto;
import com.example.cartservice.dto.CartDto;
import com.example.cartservice.dto.mapping.CartMapper;
import com.example.cartservice.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j //  Annotation that generates a logger for the class.
@Service // Indicates that this class is a service component in Spring.
@RequiredArgsConstructor // Annotation that generates a constructor with all final fields.
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;
    private final CartRepository cartRepository;
    @Override
    public CartDto addCart(CartCreationDto cartCreationDto) {
//        log.info(SEARCHING_BOOK_BY_TITLE_LOG, bookCreationDto.getTitle());
      //  final Optional<Cart> bookSearch = bookRepository.findTopByTitleEqualsIgnoreCase(bookCreationDto.getTitle());
//        if (bookSearch.isPresent()) {
//            log.error(BOOK_ALREADY_REGISTERED.getErrorDescription());
//            throw new BookAlreadyRegisteredException(BOOK_ALREADY_REGISTERED.getErrorDescription());
//        }
        final Cart cart = cartMapper.cartCreationDtoToCart(cartCreationDto);
        cartRepository.save(cart);
        log.info("Book {} registered with success.", cart.getId());
        return cartMapper.cartToCartDto(cart);
    }

    @Override
    public List<CartDto> findAllCarts() {
        final List<Cart> carts = cartRepository.findAll();
        return cartMapper.cartListToCartListDto(carts);
    }
}
