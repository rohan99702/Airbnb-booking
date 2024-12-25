package com.airbnb_booking.service;

import com.airbnb_booking.entity.AppUser;
import com.airbnb_booking.payload.AppUserDto;
import com.airbnb_booking.repository.AppUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService
{
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private ModelMapper modelMapper;

    public boolean isEmailPresent(String email)
    {
        Optional<AppUser> appUser=appUserRepository.findByEmail(email);
        if(appUser.isPresent()){return true;}
        return false;
    }

    public boolean isUsernamePresent(String username)
    {
        Optional<AppUser> appUser=appUserRepository.findByUsername(username);
        if(appUser.isPresent()){return true;}
        return false;
    }

    public AppUserDto saveUser(AppUserDto appUserDto)
    {
        AppUser appUser=modelMapper.map(appUserDto,AppUser.class);
        appUser.setPassword(BCrypt.hashpw(appUserDto.getPassword(),BCrypt.gensalt(10)));
        AppUser savedUser=appUserRepository.save(appUser);
        return modelMapper.map(savedUser,AppUserDto.class);
    }
}
