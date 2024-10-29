package com.example.cartservice.exception;

public class CartAlreadyExists extends RuntimeException {

    public CartAlreadyExists(String message) {
        super(message);
    }
}
