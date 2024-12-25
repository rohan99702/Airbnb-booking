package com.airbnb_booking.service;

import com.airbnb_booking.entity.AppUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class JWTService {
    @Value("${jwt.algorithm.key}")
    private String algorithmKey;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiry.duration}")
    private int expiryTime;

    private Algorithm algorithm;
    private static final String username="username";

    @PostConstruct
    public void PostConstruct() throws UnsupportedEncodingException
    {
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public String createToken(AppUser appUser)
    {
       return JWT.create().withClaim(username, appUser.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiryTime))
                .withIssuer(issuer).sign(algorithm);
    }
    public String getUsername(String token)
    {
        DecodedJWT decodedJWT=JWT.require(algorithm).withIssuer(issuer).build().verify(token);
        return decodedJWT.getClaim(username).asString();
    }
}
