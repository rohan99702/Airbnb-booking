package com.airbnb_booking.controller;

import com.airbnb_booking.payload.JWTToken;
import com.airbnb_booking.payload.LoginDto;
import com.airbnb_booking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")    //http://localhost:8080/api/v1/login
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto)
    {
        JWTToken jwtToken= loginService.checkCredentials(loginDto);
        if(jwtToken!=null)
        {
            return new ResponseEntity<>(jwtToken, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid Credentials",HttpStatus.UNAUTHORIZED);
    }
}
