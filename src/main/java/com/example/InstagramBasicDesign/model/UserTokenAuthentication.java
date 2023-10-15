package com.example.InstagramBasicDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserTokenAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tokenId;
    private String token;
    private LocalDate tokenCreationDate;

    public UserTokenAuthentication(User user){
        this.user = user;
        this.tokenCreationDate = LocalDate.now();
        this.token = UUID.randomUUID().toString();
    }

    @OneToOne
    @JoinColumn(name = "fk_usr_id")
    private User user;
}
