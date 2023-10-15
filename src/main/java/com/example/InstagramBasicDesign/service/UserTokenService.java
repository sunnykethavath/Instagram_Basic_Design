package com.example.InstagramBasicDesign.service;

import com.example.InstagramBasicDesign.model.UserTokenAuthentication;
import com.example.InstagramBasicDesign.model.dto.AuthenticationInputDto;
import com.example.InstagramBasicDesign.repo.IUserRepo;
import com.example.InstagramBasicDesign.repo.IUserTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService {
    @Autowired
    IUserTokenRepo tokenRepo;

    public void createToken(UserTokenAuthentication token){
        tokenRepo.save(token);
    }

    public void deleteToken(String tokenValue){

        UserTokenAuthentication token = tokenRepo.findFirstByToken(tokenValue);
        tokenRepo.delete(token);
    }

    public boolean authenticate(AuthenticationInputDto authInfo){

        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        UserTokenAuthentication token = tokenRepo.findFirstByToken(tokenValue);
        if(token != null){
            return token.getUser().getEmail().equals(email);
        }else
            return false;
    }
}
