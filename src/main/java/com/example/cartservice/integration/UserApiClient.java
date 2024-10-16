package com.example.cartservice.integration;


import com.example.cartservice.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class UserApiClient {
    private static final String USER_SERVICE_URL = "http://localhost:8081/user-service/v1/users/";

    public static UserDto getUserById(String userId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> response = restTemplate.getForEntity(USER_SERVICE_URL + userId, UserDto.class);
        return response.getBody();
    }
}