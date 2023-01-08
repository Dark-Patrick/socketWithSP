package com.lch.socketdemo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtil {
    private static final String SIGN = "!@_@LCH^-^hello!";
    /**
     * 生成token header.payload.sign
     */
    public static String getToken(Map<String, String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1);//一天过期

        JWTCreator.Builder builder = JWT.create();

        map.forEach((k, v)->{
            builder.withClaim(k, v);
        });

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGN));
        return token;
    }

//    /**
//     * 验证Token
//     */
//    public static void verifyToken(String token){
//        JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
//    }

    /**
     * 获取Token信息
     */
    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }
}
