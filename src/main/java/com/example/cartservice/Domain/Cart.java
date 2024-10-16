package com.example.cartservice.Domain;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "carts")
public class Cart {

    @Id
    private String id;

    @NotNull
    private String idUser;

    @NotNull
    private List<String> booksIds;
}
