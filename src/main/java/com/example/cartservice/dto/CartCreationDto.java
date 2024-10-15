package com.example.cartservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCreationDto {

    @Id
    private String id;

    @NotNull
    private String idUser;

    @NotNull
    private List<String> booksIds;

}
