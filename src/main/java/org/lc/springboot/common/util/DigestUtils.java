package org.lc.springboot.common.util;

import org.lc.springboot.common.Algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author lc
 * @date 2018-12-16 17:42:26
 * @version 1.0.0
 * @since 1.0.0
 */
public class DigestUtils {

    private static final String MD5_ALGORITHM_NAME = "MD5";

    private static final String BASE64_ALGORITHM_NAME = "BASE64";

    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String digestAsHexString(String s, Algorithm algorithm) {
        String digestString;
        switch (algorithm.getMsg()) {
            case MD5_ALGORITHM_NAME: digestString = md5DigestAsHexString(s); break;
            case BASE64_ALGORITHM_NAME: digestString = null; break;
            default: throw new IllegalStateException("没有找到该算法");
        }
        return digestString;
    }

    public static String digestAsHexString(String s, String algorithm) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("未找到该算法", e);
        }
        byte[] bytes = digest.digest(s.getBytes());
        return encodeHex(bytes);
    }

    private static String md5DigestAsHexString(String message) {
        MessageDigest md5Digest;
        try {
            md5Digest = MessageDigest.getInstance(MD5_ALGORITHM_NAME);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("找不到该算法", e);
        }
        byte[] bytes = md5Digest.digest(message.getBytes());
        return encodeHex(bytes);
    }

    private static String encodeHex(byte[] bytes) {
        char[] chars = new char[32];
        for (int i = 0; i < chars.length; i = i + 2) {
            byte b = bytes[i / 2];
            chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];
            chars[i + 1] = HEX_CHARS[b & 0xf];
        }
        return new String(chars);
    }
}
