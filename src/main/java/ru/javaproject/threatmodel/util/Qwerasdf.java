package ru.javaproject.threatmodel.util;

import java.security.MessageDigest;

public class Qwerasdf{
    public static String getHash(String str)throws Exception     {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());

        byte[] dataBytes = md.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataBytes.length; i++) {
            sb.append(Integer.toString((dataBytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}