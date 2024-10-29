package com.example.cartservice.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum representing different error types and their messages.
 */
@Getter
@AllArgsConstructor
public enum Error {

    NO_USERS_FOUND("NO_USERS_FOUND", "No users were found."),
    NO_CART_FOUND_BY_ID("NO_CART_FOUND_BY_ID", "No cart was found by ID."),
    NO_USER_FOUND_BY_FIRST_AND_LAST_NAME("NO_USER_FOUND_BY_FIRST_AND_LAST_NAME",
            "No user was found by first and last name."),
    CART_ALREADY_EXISTS("CART_ALREADY_EXISTS", "Cart already exists for the given user."),;

    private final String errorMessage;
    private final String errorDescription;
}
