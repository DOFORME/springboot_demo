package org.lc.springboot.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

public class Memory {

    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest("admin".getBytes());
        String md5Code = new BigInteger(1, bytes).toString(16);


        System.out.println(Arrays.toString(bytes));
        System.out.println(md5Code);
    }
}
//    private static char[] encodeHex(byte[] bytes) {
//        char[] chars = new char[32];
//        for (int i = 0; i < chars.length; i = i + 2) {
//            byte b = bytes[i / 2];
//            chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];
//            chars[i + 1] = HEX_CHARS[b & 0xf];
//        }
//        return chars;
//    }
//}

//        StringBuffer md5Code = new StringBuffer();
//        for (byte b : bytes) {
//            md5Code.append(Integer.toHexString(b & 0xff));
//        }
//
//        System.out.println(Arrays.toString(bytes));
//                System.out.println(md5Code.length());
//                System.out.println(md5Code);
//
//
//                String springMd5 = DigestUtils.md5DigestAsHex("test".getBytes());
//                System.out.println(springMd5.length());
//                System.out.println(springMd5);
//
//                System.out.println(Integer.toHexString(10 & 0xff));
//
//                System.out.println((33 >>> 0x4) & 0xf);