package com.railwayApp.api.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private Long validityInMilliseconds;


    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private Claims generateClaims(UserDetails userDetails) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + validityInMilliseconds);

        Claims claims = Jwts.claims()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiration);
        claims.put("roles", userDetails.getAuthorities());
        return claims;
    }

    private String generateToken(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractUsername(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject();
    }

    public String createToken(UserDetails userDetails) {
        Claims claims = generateClaims(userDetails);
        return generateToken(claims);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
