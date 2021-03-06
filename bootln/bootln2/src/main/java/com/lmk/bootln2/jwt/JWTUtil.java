package com.lmk.bootln2.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JWTUtil {

    //过期时间5分钟
    private static final  long EXPIRE_TIME = 5*60*1000;

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param username
     * @param secret 密码
     * @return
     */
    public static boolean verify(String token,String username,String secret){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        try {
            JWTVerifier verifier = JWT.require(algorithm).
                    withClaim("username", username).
                    build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @param token
     * @return token中包含的用户名
     */
    public static String getUsername(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        }catch (Exception e){
            return null;
        }

    }

    /**
     * 生成签名 5分钟之后过期
     * @param username 用户名
     * @param secret 用户密码
     * @return 加密的token
     */
    public static String sign(String username,String secret){
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withClaim("username",username).withExpiresAt(date).sign(algorithm);
        }catch (Exception e){
            return null;
        }
    }
}
