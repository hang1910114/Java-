package com.neu.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    public static final String USER_ID = "user_id";
    public static final String CUSTOMER_ID = "customer_id";

    public static String generateToken(Map<String,Object> claimInfo, String key, int expire)  {

        long expMillis = System.currentTimeMillis() + expire*1000;
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setClaims(claimInfo)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }

    /**
     * 从token中获取原始信息
     * @param token
     * @param key
     * @return
     * @throws Exception
     */
    public static Map<String,Object> parseJWT(String token, String key)  {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return body;
    }
}