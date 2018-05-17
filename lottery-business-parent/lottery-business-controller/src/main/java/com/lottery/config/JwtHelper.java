package com.lottery.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;

import javax.xml.bind.DatatypeConverter;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class JwtHelper {
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String createJWT(String id, String loginName, String jwtSecretKey) {
        Date now = new Date();
        String token = Jwts.builder().setSubject(loginName)
                .compressWith(CompressionCodecs.DEFLATE)
                .signWith(SignatureAlgorithm.HS256, jwtSecretKey)
                .setIssuedAt(now)
                .claim("id", id)
                .claim("loginName", loginName)
                .setExpiration(Date.from(Instant.now().plus(7, ChronoUnit.DAYS))) // 有效期一个星期
                .compact();
        return token;
    }
}