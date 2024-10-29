package com.example.cartservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Data Transfer Object (DTO) of user.
 */
@Data
public class UserDto {

    @Id
    private String id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String ssn;

    private List<String> booksIds;
}

