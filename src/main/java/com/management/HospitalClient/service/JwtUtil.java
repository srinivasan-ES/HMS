package com.management.HospitalClient.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    public  String createToken() {
        return Jwts.builder()
                .claim("role","admin")
                .setIssuer("hospital-auth")
                .setSubject("hospital-client")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000))
                .signWith(SignatureAlgorithm.HS256, "r2vKwj88InDU9QuOnorfIgAJsLvGd50r".getBytes())
                .compact();
    }

    public  Key getSignKey() {
        byte[] keyBytes = "Sribalajifdcsdfsdfsdfsdfsfsd".getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
