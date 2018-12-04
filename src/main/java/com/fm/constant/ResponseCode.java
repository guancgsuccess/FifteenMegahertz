package com.fm.constant;

/**
 * Created on 2018/10/20.
 *
 * @author guochangji
 *  定义响应的状态码
 */
public enum ResponseCode {

    /**
     * 成功状态码
     */
    SUCCESS(1,"SUCCESS"),
    /**
     * 错误状态码
     */
    ERROR(0,"ERROR"),
    /**
     * 失败状态码
     */
    FAILURE(2,"FAILURE"),
    /**
     * 需要登录状态码
     */
    NEED_LOG(4,"NEED_LOG"),

    /**
     * 已登录状态码
     */
    HAS_LOG(3,"HAS_LOG"),
    /**
     * 在线消息码
     */
    ONLINE_MSG(5,"ONLINE_MSG"),
    /**
     * 离线消息码
     */
    OFFLINE_MSG(6,"OFFLINE_MSG");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

