package com.example.cartservice.Service;

import com.example.cartservice.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {
    private static final String BOOK_SERVICE_URL = "http://localhost:8085/book-service/v1/books/";

    public static BookDto getBookByTitle(String bookTitle) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BookDto> response = restTemplate.getForEntity(BOOK_SERVICE_URL + bookTitle, BookDto.class);
        return response.getBody();
    }
}

