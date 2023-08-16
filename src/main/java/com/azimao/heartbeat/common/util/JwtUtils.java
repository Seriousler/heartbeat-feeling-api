package com.azimao.heartbeat.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class JwtUtils {

    static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    //设置token过期时间，毫秒
    public static final Long EXPIRE = 1000 * 60 * 10L;
    //设置token密钥
    public static final String APP_SECRET = "heartbeat-feeling-api";

    public static String getJwtToken(String openid) {
        logger.info("openid：{}", openid);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("openid", openid)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }

    public static String getOpenidByJwtToken(String jwtToken) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("openid");
    }

}
