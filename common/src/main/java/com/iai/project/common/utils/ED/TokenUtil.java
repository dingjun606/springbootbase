package com.iai.project.common.utils.ED;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;

/**
 * token工具类
 */
public class TokenUtil {

    //token过期时间，单位：毫秒（此处设置为60分钟后过期）
    private static final int EXPIRE_DATE = 1000 * 60 * 60;

    //token秘钥
    private static final String TOKEN_SECRET = "A*S@32';'S!A^&*AS7DJ";

    /**
     * 根据账户密码生成token
     *
     * @param account  账号
     * @param password 密码
     */
    public static String createToken(String account, String password) {

        //设置token过期时间
        Date now = new Date();
        Date expire = new Date(now.getTime() + EXPIRE_DATE);

        //携带账号，密码生成token
        return JWT.create()
                .withClaim("account", account)
                .withClaim("password", password)
                .withExpiresAt(expire)
                .sign(Algorithm.HMAC256(TOKEN_SECRET));
    }


    /**
     * 验证token，通过返回true
     *
     * @param token
     */
    public static boolean verifyToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 解析token
     *
     * @param token
     */
    public static DecodedJWT getTokenInfo(String token) {
        return JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
    }

}
