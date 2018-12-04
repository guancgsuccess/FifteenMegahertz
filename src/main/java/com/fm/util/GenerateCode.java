package com.fm.util;

/**
 * 此类用于生成随机验证码:  6位0-9数字
 */
public class GenerateCode {
    public static String getCode(){
        char[] code=new char[6];
        int num=0;
        for(int i=0;i<code.length;i++){
            code[num++]= (char) ((int) (Math.random() * 10)+'0');
        }
        return new String(code);
    }
}
