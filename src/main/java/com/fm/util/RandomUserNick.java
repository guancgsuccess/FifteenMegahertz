package com.fm.util;

import java.util.UUID;

/**
 * 自动创建用户名
 * Created on 2018/10/15.
 * @author haonan.
 */
public class RandomUserNick {
    public static String GetGUID()
    {
        return "15M_"+UUID.randomUUID().toString().replace("-","").substring(0,8);
    }

}
