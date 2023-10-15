package com.example.InstagramBasicDesign.repo;

import com.example.InstagramBasicDesign.model.UserTokenAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTokenRepo extends JpaRepository<UserTokenAuthentication,Integer> {
    UserTokenAuthentication findFirstByToken(String tokenValue);
}
