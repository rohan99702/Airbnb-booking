package com.airbnb_booking.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfiguration
{
    @Autowired
    private JWTFilter jwtFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.cors().disable().csrf().disable().authorizeHttpRequests().anyRequest().permitAll();
        /*http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtFilter, AuthorizationFilter.class);
        http.authorizeHttpRequests()
                .requestMatchers("/api/v1/appuser/**","/api/v1/login/**").permitAll()
                .requestMatchers("/api/v1/property/**").hasAnyRole("OWNER","ADMIN").anyRequest().authenticated();*/
        return http.build();
    }
}
