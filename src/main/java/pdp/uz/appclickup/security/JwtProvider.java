package pdp.uz.appclickup.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class JwtProvider {
    private static final long expireTime = 1000*360*122;
    private static final String secretSuz = "maxfiysuzHechKimBilmasin";

    public String generateToken(String username){
        Date expireDate = new Date(System.currentTimeMillis()+expireTime);
        String token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secretSuz)
                .compact();
        return token;
    }

    public String getEmailFromToken(String token){
        try {
            String tokens = Jwts
                    .parser()
                    .setSigningKey(secretSuz)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return tokens;
        }catch (Exception e){
            return null;
        }
    }
}
