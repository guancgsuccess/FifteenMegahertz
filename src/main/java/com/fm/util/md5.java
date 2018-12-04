package com.fm.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * @author gcc
 */
public class md5 {
    /**
     * 密码加密处理（md5）
     *   @param enc 原密码
     *   @return 加密后的内容
     */
     	public static String md5Encrypt(String enc) {
            try {//采用MD5处理
                MessageDigest md = MessageDigest.getInstance("md5");
                 return new BASE64Encoder().encodeBuffer(enc.getBytes()).trim();
            }
              catch(Exception e){
                	return "";
            }
     	}


    /**
     * 密码解密密处理（md5）
     * @param dec 原密码
     * @return 加密后的内容
     */
     	public static String md5Decrypt(String dec){
            try {//采用MD5处理
                MessageDigest md = MessageDigest.getInstance("md5");
                // 将加密结果output利用Base64转成字符串输出
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            try {
                return new String(new BASE64Decoder().decodeBuffer(dec)).trim();
            } catch (IOException e) {
                return "";
            }


        }

}
