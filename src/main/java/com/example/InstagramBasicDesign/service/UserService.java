package com.example.InstagramBasicDesign.service;

import com.example.InstagramBasicDesign.model.User;
import com.example.InstagramBasicDesign.model.UserTokenAuthentication;
import com.example.InstagramBasicDesign.model.dto.AuthenticationInputDto;
import com.example.InstagramBasicDesign.model.dto.SignInInputDto;
import com.example.InstagramBasicDesign.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    UserTokenService userTokenService;
    public String SignUp(User user) {

        String email = user.getEmail();

        User existingEmail = userRepo.findFirstByEmail(email);

        if(existingEmail != null)
            return "Email already in use";

        String password = user.getPassword();

        try{
            String encryptedPassword = PasswordEncryptor.encrypt(password);
            user.setPassword(encryptedPassword);

            userRepo.save(user);
            return "user registered";
        }catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public String SignIn(SignInInputDto signInInputDto) {

        String email = signInInputDto.getEmail();

        User existingEmail = userRepo.findFirstByEmail(email);

        if(existingEmail == null)
            return "signup first";
        
        String password = signInInputDto.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if (existingEmail.getPassword().equals(encryptedPassword)) {
                // return a token for this sign in
                UserTokenAuthentication token = new UserTokenAuthentication(existingEmail);
                return token.getToken();
            } else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        }catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String signOut(AuthenticationInputDto authInfo) {

        if(userTokenService.authenticate(authInfo)){
            String token = authInfo.getTokenValue();
            userTokenService.deleteToken(token);
            return "sign out successful";
        }else {
            return "Un Authenticated access!!!";
        }
    }


    public String updateUser(User user) {
        userRepo.save(user);
        return "user details updated";
    }
}
