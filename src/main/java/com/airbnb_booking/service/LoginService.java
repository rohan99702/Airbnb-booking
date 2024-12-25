package com.airbnb_booking.service;

import com.airbnb_booking.entity.AppUser;
import com.airbnb_booking.payload.JWTToken;
import com.airbnb_booking.payload.LoginDto;
import com.airbnb_booking.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoginService
{
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private JWTService jwtService;

    public JWTToken checkCredentials(LoginDto loginDto)
    {
        Optional<AppUser> appUser=appUserRepository.findByUsername(loginDto.getUsername());
        if(appUser.isPresent())
        {
            AppUser user= appUser.get();
            if(BCrypt.checkpw(loginDto.getPassword(),user.getPassword()))
            {
                String token= jwtService.createToken(user);
                JWTToken jwtToken=new JWTToken();
                jwtToken.setTokenType("JWT");
                jwtToken.setToken(token);
                return jwtToken;
            }
        }
        return null;
    }
}
