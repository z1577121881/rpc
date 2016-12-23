package com.whatdy.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/**
 *加密工具类
 */
public class Digest {
    /**
     * aes 加密
     * @param content  需要加密的内容
     * @return 解密之后的内容
     */
    public static String encodeAes(String content){
        String p = null;
        try {
            KeyGenerator aesKeyGenerator = KeyGenerator.getInstance("aes");
            SecretKey aesSecretKey = aesKeyGenerator.generateKey();
            Cipher aesCipher = Cipher.getInstance("aes");
            aesCipher.init(Cipher.ENCRYPT_MODE, aesSecretKey);
            byte[] aseResultBytes = aesCipher.doFinal(content.getBytes());
            p = new String(Base64.encodeBase64(aseResultBytes));
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }
    public static String decodeAes(String content){
        String p = null;
        try{
            KeyGenerator aesKeyGenerator = KeyGenerator.getInstance("aes");
            SecretKey aesSecretKey = aesKeyGenerator.generateKey();
            Cipher aesCipher = Cipher.getInstance("aes");
            byte[] aseResultBytes = aesCipher.doFinal(content.getBytes());
            aesCipher.init(Cipher.DECRYPT_MODE, aesSecretKey);
            aseResultBytes = aesCipher.doFinal(aseResultBytes);
            p = new String(aseResultBytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    /**
     * test
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //加密内容
        final String content = "hello hello hello";
        /*
         * 单向加密 md5 & sha
         */
        //md5 加密
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] md5SecretStr = md5.digest(content.getBytes());
        System.out.print("md5 加密 : { " + new String(Base64.encodeBase64(md5SecretStr)) + " }\n\r");

        //sha 加密
        MessageDigest sha = MessageDigest.getInstance("sha");
        byte[] shaSecretBytes = sha.digest(content.getBytes());
        System.out.print("sha 加密 : { " + new String(Base64.encodeBase64(shaSecretBytes)) + " }\n\r");

        /*
         * 对称加密 aes & des
         */
        //aes 加密
        KeyGenerator aesKeyGenerator = KeyGenerator.getInstance("aes");
        SecretKey aesSecretKey = aesKeyGenerator.generateKey();
        Cipher aesCipher = Cipher.getInstance("aes");
        aesCipher.init(Cipher.ENCRYPT_MODE, aesSecretKey);
        byte[] aseResultBytes = aesCipher.doFinal(content.getBytes());
        System.out.print("aes 加密 : { " + new String(Base64.encodeBase64(aseResultBytes)) + " }\n\r");

        //aes 解密
        aesCipher.init(Cipher.DECRYPT_MODE, aesSecretKey);
        aseResultBytes = aesCipher.doFinal(aseResultBytes);
        System.out.print("aes 解密: { " + new String(aseResultBytes) + " }\n\r");


        //des 加密
        KeyGenerator desKeyGenerator = KeyGenerator.getInstance("aes");
        SecretKey desSecretKey = desKeyGenerator.generateKey();
        Cipher desCipher = Cipher.getInstance("aes");
        desCipher.init(Cipher.ENCRYPT_MODE, desSecretKey);
        byte[] dseResultBytes = desCipher.doFinal(content.getBytes());
        System.out.print("des 加密 : { " + new String(Base64.encodeBase64(dseResultBytes)) + " }\n\r");

        desCipher.init(Cipher.DECRYPT_MODE, desSecretKey);
        dseResultBytes = desCipher.doFinal(dseResultBytes);
        System.out.print("aes 解密: { " + new String(dseResultBytes) + " }\n\r");
    }
}
