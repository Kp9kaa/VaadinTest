package com.example.samback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class User {

    private String firstName;
    private String secondName;
    private Integer age;
    private String gender;
}
