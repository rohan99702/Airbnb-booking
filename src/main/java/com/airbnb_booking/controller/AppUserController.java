package com.airbnb_booking.controller;

import com.airbnb_booking.exception.UserExists;
import com.airbnb_booking.payload.AppUserDto;
import com.airbnb_booking.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appuser")
public class AppUserController
{
    @Autowired
    private AppUserService appUserService;

    //http://localhost:8080/api/v1/appuser/createUser
    @PostMapping("/createUser")
    public ResponseEntity<?> addNewUser(@RequestBody AppUserDto appUserDto)
    {
        if(appUserService.isEmailPresent(appUserDto.getEmail()))
        {
            throw new UserExists("Email id exists");
        }
        if(appUserService.isUsernamePresent(appUserDto.getUsername()))
        {
            throw new UserExists("Username exists");
        }
        appUserDto.setRole("ROLE_USER");
        AppUserDto dto=appUserService.saveUser(appUserDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/appuser/createProprtyOwner
    @PostMapping("/createProprtyOwner")
    public ResponseEntity<?> addNewPropertyOwner(@RequestBody AppUserDto appUserDto)
    {
        if(appUserService.isEmailPresent(appUserDto.getEmail()))
        {
            throw new UserExists("Email id exists");
        }
        if(appUserService.isUsernamePresent(appUserDto.getUsername()))
        {
            throw new UserExists("Username exists");
        }
        appUserDto.setRole("ROLE_OWNER");
        AppUserDto dto=appUserService.saveUser(appUserDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

