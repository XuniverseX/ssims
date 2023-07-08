package com.xuni.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignMD5 {
    public static String getMD5(String str) {
        String res;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuffer buffer = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buffer.append("0");
                buffer.append(Integer.toHexString(i));
            }
            res = buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "username=hhk&money=10&salt=xuni";
        System.out.println(getMD5(str));
    }
}
