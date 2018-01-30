package com.stone.utils.encrypt;

/**
 * Created by chenghao on 8/12/16.
 */
public class Base64 {
    public static byte[] encode(byte[] s){
        return java.util.Base64.getEncoder().encode(s);

    }

    public static byte[] encode(String s){
        return encode(s.getBytes());
    }

    public static byte[] decode(byte[] s){
        return java.util.Base64.getDecoder().decode(s);
    }

    public static byte[] decode(String s){
        return decode(s.getBytes());
    }
}
