package com.fm.aop;

import com.alibaba.fastjson.JSON;
import com.fm.entity.common.Message;
import com.fm.entity.common.ServerResponse;
import com.fm.socket.MyWebSocketHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.socket.TextMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018/10/31.
 *
 * @author guochangji
 */
@Component
@Aspect
public class SocketAspect {

    @Bean
    public MyWebSocketHandler myWebSocketHandler() {
        return new MyWebSocketHandler();
    }

    /**
     * 推送关注信息
     * @param joinPoint 切入点
     * @param result 方法的返回值
     */
    @AfterReturning(value = "execution(public * com.fm.service.CustomerFollowService.addFollow(..))", returning = "result")
    public void sendMessage(JoinPoint joinPoint,Object result){
        if((boolean) result){
            /*获取request*/
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Message message=new Message();
            message.setFromName((String) request.getSession().getAttribute("custNick"));
            message.setFromProfile((String) request.getSession().getAttribute("custProfile"));
            message.setFromId((Integer) joinPoint.getArgs()[0]);
            message.setToId((Integer) joinPoint.getArgs()[1]);
            message.setMessageTime(new Date());
            message.setMessageText("关注了你");
            Map<String,Object> data=new HashMap<>(1);
            data.put("message", message);
            myWebSocketHandler().sendMessageToUser((Integer) joinPoint.getArgs()[1],new TextMessage(JSON.toJSONString(ServerResponse.createByOnline("在线消息",data))));

        }
    }
}
