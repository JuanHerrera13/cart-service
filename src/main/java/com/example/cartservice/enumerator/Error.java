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
    NO_USER_FOUND_BY_ID("NO_USER_FOUND_BY_ID", "No user was found by ID."),
    NO_USER_FOUND_BY_FIRST_AND_LAST_NAME("NO_USER_FOUND_BY_FIRST_AND_LAST_NAME",
            "No user was found by first and last name."),
    USER_ALREADY_EXISTS("USER_ALREADY_EXISTS", "User already exists."),;

    private final String errorMessage;
    private final String errorDescription;
}
