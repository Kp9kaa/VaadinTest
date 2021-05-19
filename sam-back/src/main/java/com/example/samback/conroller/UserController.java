package com.example.samback.conroller;

import com.example.samback.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> receiveUsers() {
        return ResponseEntity.ok(List.of(User.builder().firstName("Vadim").secondName("Mitin").age(30).gender("MALE").build(),
                User.builder().firstName("Test").secondName("TestSecond").age(20).gender("FEMALE").build()));
    }
}
