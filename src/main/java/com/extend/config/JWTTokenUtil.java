package com.extend.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.extend.bean.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenUtil implements Serializable {
	private static final long serialVersionUID=-2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 5*60*60;
//	@Value("${jwt.secret}")
	private String secret="java";
	
	 private String doGenerateToken(Map<String, Object> claims, String subject) {
	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	        		.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
	        		.signWith(SignatureAlgorithm.HS512,secret).compact();
	    }
	 
	public String generateToken(Employee employee) {
		Map<String, Object>claims=new HashMap<>();
		return doGenerateToken(claims,employee.getPhonenumber());
	}
	public String getUsernameFromToken(String Token) {
        return getClaimFromToken(Token, Claims::getSubject);
    }
    public <T> T getClaimFromToken(String Token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(Token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String Token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(Token).getBody();
    }
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public Boolean validateToken(String token, Employee user) {
        final String userName = getUsernameFromToken(token);
        return (userName.equals(user.getPhonenumber()) && !isTokenExpired(token));
    }
}
