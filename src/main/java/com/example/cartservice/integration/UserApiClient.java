package com.example.cartservice.integration;

import com.example.cartservice.dto.UserDto;
import com.example.cartservice.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserApiClient {
    private static final String USER_SERVICE_URL = "http://localhost:8082/user-service/v1/users/";

    public void getUserById(String userId) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            log.info("Chamando user service com userId: {}", userId);
            ResponseEntity<UserDto> response = restTemplate.getForEntity(USER_SERVICE_URL + userId, UserDto.class);
            response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            log.error("Usuário não encontrado!");
            throw new NotFoundException("Usuário não foi encontrado com o id "
                    + userId);
        } catch (Exception e) {
            log.error(e.toString());
            throw new RestClientException(e.getMessage());
        }
    }
}