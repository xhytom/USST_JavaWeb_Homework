package org.example.backend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import java.util.Date;

public class JWTUtil {

    private static final String SECRET_KEY = "xhytom123123";  // 替换为你的密钥

    // 解析 JWT Token
    public static Claims parseToken(String token) {
        try {
            // 使用 Jwts.parser() 而非 parserBuilder()
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)  // 设置密钥
                    .parseClaimsJws(token)     // 解析 Token
                    .getBody();                // 获取 Token 内容
        } catch (SignatureException e) {
            // 如果签名验证失败，处理异常
            throw new RuntimeException("Invalid token", e);
        }
    }

    // 创建 JWT Token


    public static String createToken(String username) {
        long expire = 604800; // 7 天
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                .setSubject(username)              // 设置用户信息
                .setIssuedAt(new java.util.Date()) // 设置创建时间
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 设置过期时间 24小时
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET_KEY)  // 设置签名算法与密钥
                .compact();  // 生成 Token
    }
}
