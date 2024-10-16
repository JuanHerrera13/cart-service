package com.example.cartservice.integration;

import com.example.cartservice.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookApiClient {
    private static final String BOOK_SERVICE_GET_BY_ID = "http://localhost:8085/book-service/v1/books/";

    public static BookDto getBookByTitle(String bookTitle) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BookDto> response = restTemplate.getForEntity(BOOK_SERVICE_GET_BY_ID + bookTitle, BookDto.class);
        return response.getBody();
    }
}

