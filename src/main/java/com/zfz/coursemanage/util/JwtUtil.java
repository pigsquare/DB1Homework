package com.zfz.coursemanage.util;


import com.zfz.coursemanage.entity.Admin;
import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.entity.T;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@EnableConfigurationProperties
@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String getIdFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(S user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "s");
        return doGenerateToken(claims, user.getSno());
    }

    public String generateToken(T user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "t");
        return doGenerateToken(claims, user.getTno());
    }

    public String generateToken(Admin user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "a");
        return doGenerateToken(claims, user.getId());
    }

    private String doGenerateToken(Map<String, Object> claims, String id) {
        long expirationTimeLong = Long.parseLong(expiration);

        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(id)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
