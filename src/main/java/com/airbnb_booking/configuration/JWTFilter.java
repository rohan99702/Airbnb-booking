package com.airbnb_booking.configuration;

import com.airbnb_booking.entity.AppUser;
import com.airbnb_booking.repository.AppUserRepository;
import com.airbnb_booking.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String token=request.getHeader("Authorization");
      if(token!=null&&token.startsWith("Bearer "))
        {
           String tokenval= token.substring(8,token.length()-1);
           String username=jwtService.getUsername(tokenval);
           Optional<AppUser> appUser=appUserRepository.findByUsername(username);
           if(appUser.isPresent())
           {
               AppUser user=appUser.get();
               UsernamePasswordAuthenticationToken auth=
                       new UsernamePasswordAuthenticationToken
                               (user,null, Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
               auth.setDetails(new WebAuthenticationDetails(request));
               SecurityContextHolder.getContext().setAuthentication(auth);
           }
        }
      filterChain.doFilter(request,response);
    }
}
//Collection.Sigleton-collection with only one object
