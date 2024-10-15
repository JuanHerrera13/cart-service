package com.example.cartservice.Service;

import com.example.cartservice.dto.BookDto;
import com.example.cartservice.dto.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CartServiceApplication.class, args);

        BookDto book = BookService.getBookByTitle("teste");
        System.out.println(book.getTitle());

        UserDto user = UserService.getUserById("670d68f7406f3563a3629e65");
        System.out.println(user.getFirstName());
    }
}
