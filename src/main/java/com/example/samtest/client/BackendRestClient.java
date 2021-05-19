package com.example.samtest.client;

import com.example.samtest.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class BackendRestClient {

    private final RestTemplate restTemplate;

    public List<User> receiveUsers() {
        return List.of(restTemplate.getForObject("http://localhost:8081", User[].class));
    }
}
