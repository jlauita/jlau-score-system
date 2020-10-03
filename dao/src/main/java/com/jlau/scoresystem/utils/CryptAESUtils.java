package com.jlau.scoresystem.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * Created by cxr1205628673 on 2020/9/21.
 */
public class CryptAESUtils {
    private static final String AESTYPE = "AES/ECB/PKCS5Padding";
    public static String AES_Encrypt(String keyStr,String plainText){
        byte[] encrypt =null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE,key);
            encrypt = cipher.doFinal(plainText.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return new String(org.apache.tomcat.util.codec.binary.Base64.encodeBase64(encrypt));
    }
    public static String AES_Decrypt(String keyStr,String encryptStr){
        byte[] decrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE,key);
            decrypt = cipher.doFinal(org.apache.tomcat.util.codec.binary.Base64.decodeBase64(encryptStr));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new String(decrypt).trim();
    }
    public static Key generateKey(String key) throws Exception{
        try{
            SecretKeySpec keySpec =  new SecretKeySpec(key.getBytes(),"AES");
            return keySpec;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
