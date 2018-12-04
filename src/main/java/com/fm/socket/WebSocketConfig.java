package com.fm.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created on 2018/10/29.
 * WebSocket配置类
 * @author guochangji
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //前台 可以使用websocket环境
        registry.addHandler(myWebSocketHandler(),"/websocket").addInterceptors(new MyWebSocketInterceptor()).setAllowedOrigins("http://www.gcc666.top:8080");


        //前台 不可以使用websocket环境，则使用sockjs进行模拟连接
        registry.addHandler(myWebSocketHandler(), "/sockjs/websocket").addInterceptors(new MyWebSocketInterceptor()).withSockJS();
    }
    @Bean
    public WebSocketHandler myWebSocketHandler(){
        return new MyWebSocketHandler();
    }
}