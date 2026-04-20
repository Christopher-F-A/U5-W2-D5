package christopherfa.U5_W2_D5.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class TokenTools {

    @Value("${jwt.secret}")
    private String secret;

    // creazione token
    public String createToken(String email) {
        return Jwts.builder()
                .subject(email) // Chi è l'utente
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 6))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    // verifica
    public void verifyToken(String token) {
        Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseSignedClaims(token);
    }
}