package com.fm.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fm.constant.ResponseCode;

import java.util.Map;

/**
 * Created on 2018/10/20.
 *  封装通用返回对象类
 * @author guochangji
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse {
    /**
     * 状态码
     */
    private int status;
    /**
     * 数据
     */
    private Map<String,Object> data;
    /**
     * 描述信息
     */
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String,Object> getData() {
        return data;
    }

    public void setData(Map<String,Object> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ServerResponse() {
    }


    //构造函数
    /**
     * 操作成功时，返回数据
     * @param status 状态
     * @param data   数据
     * @param msg    信息
     */
    private ServerResponse(int status, Map<String,Object> data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
    /**
     * 操作成功时，返回数据
     * @param status 状态
     */
    private ServerResponse(int status) {
        this.status = status;
    }

    /**
     * 操作失败时，不返回数据
     * @param status 状态
     * @param msg 信息
     */
    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean checkIsSuccess(){
        return this.status== ResponseCode.SUCCESS.getCode();
    }

    //泛型方法
    /**
     * 成功返回数据
     * @param msg 描述信息
     * @param data 数据
     * @return 返回成功数据对象
     */
    public static ServerResponse createBySuccess(String msg,Map<String,Object> data){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),data,msg);
    }

    /**
     * 返回在线消息
     * @param msg 描述信息
     * @param data 数据
     * @return 返回在线消息对象
     */
    public static ServerResponse createByOnline(String msg,Map<String,Object> data){
        return new ServerResponse(ResponseCode.ONLINE_MSG.getCode(),data,msg);
    }

    /**
     * 返回离线消息
     * @param msg 描述信息
     * @param data 数据
     * @return 返回离线消息对象
     */
    public static ServerResponse createByOffline(String msg,Map<String,Object> data){
        return new ServerResponse(ResponseCode.OFFLINE_MSG.getCode(),data,msg);
    }

    /**
     * 校验登录信息成功
     * @return 返回校验成功对象
     */
    public static ServerResponse createByHasLogin(Map<String,Object> data){
        return new ServerResponse(ResponseCode.HAS_LOG.getCode(),data,"用户已登录!");
    }
    /**
     * 返回失败信息
     * @param msg 描述信息
     * @return 返回失败对象
     */
    public static ServerResponse createByFailure(String msg){
        return new ServerResponse(ResponseCode.FAILURE.getCode(),msg);
    }
    /**
     * 返回错误信息
     * @param msg 描述信息
     * @return 返回错误对象
     */
    public static ServerResponse createByError(String msg){
        return new ServerResponse(ResponseCode.ERROR.getCode(),msg);
    }

    /**
     * 校验登录信息失败
     * @return 返回需要登录对象
     */
    public static ServerResponse createByNeedLogin(){
        return new ServerResponse(ResponseCode.NEED_LOG.getCode(),"请先登录！");
    }

}

