package com.example.cartservice.service.impl;

import com.example.cartservice.domain.Cart;
import com.example.cartservice.exception.CartAlreadyExists;
import com.example.cartservice.exception.CartCreationException;
import com.example.cartservice.exception.NotFoundException;
import com.example.cartservice.integration.BookApiClient;
import com.example.cartservice.integration.UserApiClient;
import com.example.cartservice.service.CartService;
import com.example.cartservice.dto.CartBookListDto;
import com.example.cartservice.dto.CartCreationDto;
import com.example.cartservice.dto.CartDto;
import com.example.cartservice.dto.mapping.CartMapper;
import com.example.cartservice.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.cartservice.enumerator.Error.CART_ALREADY_EXISTS;
import static com.example.cartservice.enumerator.Error.NO_CART_FOUND_BY_ID;

@Slf4j //  Annotation that generates a logger for the class.
@Service // Indicates that this class is a service component in Spring.
@RequiredArgsConstructor // Annotation that generates a constructor with all final fields.
public class CartServiceImpl implements CartService {

    private static final String SEARCHING_CART_BY_USER_ID = "Searching cart by user id {}";

    private final CartMapper cartMapper;
    private final CartRepository cartRepository;
    private final UserApiClient userApiClient;
    private final BookApiClient bookApiClient;

    @Override
    public Cart findCartById(String id) {
        log.info("Searching cart by id {}", id);
        return cartRepository.findCartById(id)
                .orElseThrow(() -> new NotFoundException(NO_CART_FOUND_BY_ID.getErrorDescription()));
    }

    @Override
    public CartDto addCart(CartCreationDto cartCreationDto) {
        log.info(SEARCHING_CART_BY_USER_ID, cartCreationDto.getUserId());
        cartRepository.findTopByUserId(cartCreationDto.getUserId()).ifPresent(cart -> {
            log.error(CART_ALREADY_EXISTS.getErrorDescription());
            throw new CartAlreadyExists(CART_ALREADY_EXISTS.getErrorDescription());
        });
        try {
            userApiClient.getUserById(cartCreationDto.getUserId());
            for (String bookId : cartCreationDto.getBooksIds()) {
                bookApiClient.getBookById(bookId);
            }
        } catch (NotFoundException e) {
            throw new NotFoundException("Carrinho não pôde ser criado, pois: " + e.getMessage());
        } catch (Exception e) {
            throw new CartCreationException(e.getMessage());
        }
        Cart cart = cartMapper.cartCreationDtoToCart(cartCreationDto);
        cartRepository.save(cart);
        log.info("Carrinho criado com sucesso para o usuário com Id {}", cartCreationDto.getUserId());

        return cartMapper.cartToCartDto(cart);
    }

    @Override
    public List<CartDto> findAllCarts() {
        final List<Cart> carts = cartRepository.findAll();
        return cartMapper.cartListToCartListDto(carts);
    }

    @Override
    public CartDto addBook(String cartId, CartBookListDto cartBookListDto) {
        final Cart cart = this.findCartById(cartId);
        try {
            for (String bookId : cartBookListDto.getBooksIds()) {
                bookApiClient.getBookById(bookId);
            }
        } catch (NotFoundException e) {
            throw new NotFoundException("Livro não pôde ser adicionado, pois: " + e.getMessage());
        } catch (Exception e) {
            throw new CartCreationException(e.getMessage());
        }
        cart.getBooksIds().addAll(cartBookListDto.getBooksIds());
        cartRepository.save(cart);
        return cartMapper.cartToCartDto(cart);
    }

    @Override
    public CartDto removeBook(String cartId, CartBookListDto cartBookListDto) {
        final Cart cart = this.findCartById(cartId);
        cart.getBooksIds().removeAll(cartBookListDto.getBooksIds());
        cartRepository.save(cart);
        return cartMapper.cartToCartDto(cart);
    }

    @Override
    public void deleteCart(String cartId) {
        final Cart cart = this.findCartById(cartId);
        cartRepository.deleteById(cartId);
        log.info("Cart {} deleted.", cart.getId());
    }
}
