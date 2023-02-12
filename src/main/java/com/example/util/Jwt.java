package com.example.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

public class Jwt {
    private static long time = 1000*60*24;
    private static String singnature = "admin";
    public static String createToken(){
        String jwtBuilder = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim("username","admin")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256,singnature)
                .compact();

        return jwtBuilder;

    }


    public static boolean checkToken(String token) {
        if (token != null) {
            try {
                Jwts.parser().setSigningKey(singnature).parseClaimsJws(token);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

}
