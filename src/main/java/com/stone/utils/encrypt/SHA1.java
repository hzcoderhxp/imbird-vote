package com.stone.utils.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by chenghao on 8/12/16.
 */
public class SHA1 {
    private static org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(SHA1.class);
    public static String encode(String text){
        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA");
            digest.update(text.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(),e);
        }
        return "";
    }

}
