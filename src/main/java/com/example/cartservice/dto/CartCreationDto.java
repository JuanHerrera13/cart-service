package com.example.cartservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCreationDto {

    @NotNull
    private String userId;

    @NotNull
    private List<String> booksIds;

}
