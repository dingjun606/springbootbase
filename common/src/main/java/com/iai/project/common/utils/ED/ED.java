package com.iai.project.common.utils.ED;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class ED {

//    --------------AES---------------
    private static final String KEY = "yijngwyyhjdwcyuy";  // 密匙，必须16位
    private static final String ENCODING = "UTF-8"; // 编码
    private static final String ALGORITHM = "AES"; //算法
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding"; // 默认的加密算法，ECB模式

    /**
     *  AES加密
     * @param data
     * @return String
     */
    public static String AESencrypt(String data) throws Exception
    {
        KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,new SecretKeySpec(KEY.getBytes(),ALGORITHM));
        byte[] b = cipher.doFinal(data.getBytes(ENCODING));
        //采用base64算法进行转码,避免出现中文乱码
        return Base64.encodeBase64String(b);
    }

    /**
     * AES解密
     * @param data
     * @return String
     */
    public static String AESdecrypt(String data) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), ALGORITHM));
        byte[] b = cipher.doFinal(Base64.decodeBase64(data));
        //采用base64算法进行转码,避免出现中文乱码
        return new String(b);
    }
    public static void main(String[] args) throws Exception {
        String mi = ED.AESdecrypt("cjfltC1IJRAI34yzL1lqFg==");
        // String mi1 = ED.AESdecrypt("xJW8PDDqprUGxn4Kj/lXlA==");
//        System.out.println(mi);
        //System.out.println(mi1);
//        System.out.println(ED.AESencrypt("13014093752"));
        System.out.println(mi);
    }

}


