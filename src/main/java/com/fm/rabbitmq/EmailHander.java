package com.fm.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;

/**
 * Created on 2018/11/2.
 * 发送邮件服务监听器
 * @author guochangji
 */
public class EmailHander {

    @Autowired
    private EmailService emailService;


    public void sendEmailToUserHandler(String message) {
        try {
            String[] msg=message.split(",");
            emailService.sendEmailToUser(msg[0],msg[1]);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
