package cn.sdadgz.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/22 15:50:47
 */
public class JwtUtil {

    public static String createToken(String username, String password) {
        return Jwts.builder()
                .claim("username", username)
                .signWith(SignatureAlgorithm.HS256, password)
                .compact();
    }

}
