package com.example.samtest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String firstName;
    private String secondName;
    private Integer age;
    private String gender;

    @Override
    public String toString() {
        return firstName + " "
                + secondName + " "
                + age + " "
                + gender;
    }
}
