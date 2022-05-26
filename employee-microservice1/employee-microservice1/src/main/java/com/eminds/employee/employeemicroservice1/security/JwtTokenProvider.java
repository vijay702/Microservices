package com.eminds.employee.employeemicroservice1.security;

import com.eminds.employee.employeemicroservice1.exception.JwtExceptionHanlder;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationinMS;


    //Generate token

    public String generateToken(Authentication authentication){

        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationinMS );

        String token = Jwts.builder()
                      .setSubject(username)
                      .setIssuedAt(new Date())
                     .setExpiration(expireDate)
                    .signWith(SignatureAlgorithm.HS512,jwtSecret)
                    .compact();

        return token;
    }


    //get username token

    public String getUsernameFromJwt(String token){

        Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                     .parseClaimsJws(token)
                   .getBody();

        return claims.getSubject();
    }

    //method to validate jwt token

    public Boolean validateToken(String token){

       try{

           Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
           return true;
       }catch(SignatureException ex){

         throw new JwtExceptionHanlder(HttpStatus.BAD_REQUEST,"Invalid Jwt signnature");
       }catch (MalformedJwtException ex){

           throw new JwtExceptionHanlder(HttpStatus.BAD_REQUEST,"invalid jwt token");
       }
       catch (ExpiredJwtException ex){

           throw new JwtExceptionHanlder(HttpStatus.BAD_REQUEST,"Expired jwt token");
       }catch (UnsupportedJwtException ex){

           throw new JwtExceptionHanlder(HttpStatus.BAD_REQUEST,"Unsupported jwt token");
       }catch (IllegalArgumentException ex){

           throw new JwtExceptionHanlder(HttpStatus.BAD_REQUEST,"Jwt Claims String is empty");
       }



    }

}
