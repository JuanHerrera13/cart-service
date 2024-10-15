package com.example.cartservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
public class CartDto {

    @NotBlank
    private String id;

    @NotBlank
    private String idUser;

    @NotBlank
    private List<String> booksIds;
}
