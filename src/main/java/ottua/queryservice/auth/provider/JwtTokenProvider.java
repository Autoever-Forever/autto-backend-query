package ottua.queryservice.auth.provider;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    private final Key key;

    public JwtTokenProvider(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Authentication getAuthentication(String accessToken){
        Claims claims = parseClaims(accessToken);

        if(claims.get("auth") == null){
            throw new JwtException("Invalid access token");
        }

        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        UserDetails principal = new User(claims.getSubject(),"", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);

    }

    // accessToken
    public Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    // 토큰 정보를 검증하는 메서드
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            throw new JwtException("Invalid JWT token");
        } catch (ExpiredJwtException e) {
            throw new JwtException("Expired JWT Token");
        } catch (UnsupportedJwtException e) {
            throw new JwtException("Unsupported JWT Token");
        } catch (IllegalArgumentException e) {
            throw new JwtException("JWT claims String is empty");
        } catch (SignatureException e) {
            throw new JwtException("Invalid JWT signature");
        }
    }
}
