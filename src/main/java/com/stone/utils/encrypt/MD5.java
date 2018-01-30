package com.stone.utils.encrypt;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

/**
 * @author chenghao
 */
public class MD5 {



    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @return 签名结果
     */
    public static String encode(String text) {
        return encode(text, "utf-8");

    }

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @return 签名结果
     */
    public static String encode(byte[] text) {
        return DigestUtils.md5Hex(text);

    }

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String encode(String text, String input_charset) {
    	//text = text + key;
        return encode(getContentBytes(text, input_charset));
    }



    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }


}