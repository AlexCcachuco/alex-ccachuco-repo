package com.bosonit.block7crudvalidation.security;

import io.jsonwebtoken.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9ZURb2f8e7Ud";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(String name, String username){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis()+ expirationTime);

        Map<String, Object> data = new HashMap<>();
        data.put("name", name);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .addClaims(data)
                .signWith(SignatureAlgorithm.HS256,ACCESS_TOKEN_SECRET.getBytes())
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){

//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
    try{

        Jws<Claims> jws= Jwts.parser().setSigningKey(ACCESS_TOKEN_SECRET.getBytes()).parseClaimsJws(token);

        String username = jws.getBody().getSubject();
        return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

    }catch(JwtException e){
        throw new RuntimeException(e);
    }

    }

}
