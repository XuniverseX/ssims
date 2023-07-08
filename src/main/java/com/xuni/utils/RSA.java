package com.xuni.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSA {
    //公钥
    private static String rsaPublicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKhcKzs7OiW9wVwUwxip3NI6JvJiMiD0aQTWEBTMH51d0jGSEjXFcN4g4rpHhWnXmiGQbOTMpdhy2+oyGlL3hYcCAwEAAQ==";
    //私钥
    private static String rsaPrivateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAqFwrOzs6Jb3BXBTDGKnc0jom8mIyIPRpBNYQFMwfnV3SMZISNcVw3iDiukeFadeaIZBs5Myl2HLb6jIaUveFhwIDAQABAkAK52FDZkwXSqldwdh63fF3yh1goFx3xuyQTB7hgfDgO6rvdJTZheYSMn634gWbMQv+oczuGIork0xJ06Mj0Y21AiEA0QoHTSd06JRzQ+5EM9PKGjBNsvRgGliaN0RD9uC6W6UCIQDOLqh0puRx91D77ZfPkV6E/3oPYRdWFcHK6NJ8n0gEuwIgR1LNpPSWfhjQr1fnq2tS5NagXDPnanXawIqpSd3pmAUCIQDBSWBGq0YxyMY0xpGw1vii+dV1oXF9FDxuekEI71FWjQIhAIqp5Q5ogkQVZQg6BTBnLsw+KLeqMFkpzrQL1Il3hujR";

    public static void initKey() {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            rsaPublicKey = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
            rsaPrivateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
            System.out.println("Public Key: " + rsaPublicKey);
            System.out.println("Private Key: " + rsaPrivateKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String pubEncode(String src) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(rsaPublicKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] res = cipher.doFinal(src.getBytes());
            return Base64.encodeBase64String(res);
        } catch (NoSuchPaddingException | InvalidKeyException | BadPaddingException | InvalidKeySpecException |
                 IllegalBlockSizeException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String priDecode(String src) {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(rsaPrivateKey));

        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] res = Base64.decodeBase64(src);
            res = cipher.doFinal(res);
            return new String(res);
        } catch (NoSuchPaddingException | InvalidKeyException | BadPaddingException | InvalidKeySpecException |
                 IllegalBlockSizeException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        initKey();

        String passwd = "123456";
        passwd = passwd + System.currentTimeMillis();
        String passwdStr = RSA.pubEncode(passwd);
        System.out.println("公钥加密后的数据：" + passwdStr);
        System.out.println("解密后的数据：" + RSA.priDecode(passwdStr));
    }
}
