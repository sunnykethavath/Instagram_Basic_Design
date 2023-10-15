package com.example.InstagramBasicDesign.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    private Integer userid;
    private String firstName;
    private String lastName;
    private Integer age;
    @Email
    private String email;
    private String password;
    private String phoneNumber;
}
