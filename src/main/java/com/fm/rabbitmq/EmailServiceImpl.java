package com.fm.rabbitmq;

import com.fm.util.SendMailUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * Created on 2018/11/2.
 * 发送到消息队列中,处理消息队列中的信息
 * @author guochangji
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendEmailToUserQueue(String mail,String key) {
        String message=mail+","+key;
        rabbitTemplate.convertAndSend("user.forget.email.exchange", "user.forget.email",message);
    }

    @Override
    public void sendEmailToUser(String to, String key) throws MessagingException {
        SendMailUtil.sendMail(to,key);
    }
}
