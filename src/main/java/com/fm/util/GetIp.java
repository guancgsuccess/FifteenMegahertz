package com.fm.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取客户端IP
 * Created on 2018/10/11.
 * @author haonan.
 */
public class GetIp {
    public static String getIp2(HttpServletRequest request) {
               String ip = request.getHeader("X-Forwarded-For");
               if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
                    //多次反向代理后会有多个ip值，第一个ip才是真实ip
                        int index = ip.indexOf(",");
                        if(index != -1){
                               return ip.substring(0,index);
                           }else{
                                return ip;
                              }
                      }
                 ip = request.getHeader("X-Real-IP");
                 if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                     return ip;
                 }
                     return request.getRemoteAddr();
                 }
    }
