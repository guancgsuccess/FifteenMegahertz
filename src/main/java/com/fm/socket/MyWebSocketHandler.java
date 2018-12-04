package com.fm.socket;

import com.alibaba.fastjson.JSON;
import com.fm.dao.MessageDao;
import com.fm.entity.common.Message;
import com.fm.entity.common.MessageExample;
import com.fm.entity.common.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/10/29.
 *
 * @author guochangji
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {

    @Autowired
    private MessageDao messageDao;

    private static MyWebSocketHandler myWebSocketHandler;

    private Map<String,Boolean> record=new HashMap<>();

    private ServerResponse response=null;

    @PostConstruct
    public void init() {
        myWebSocketHandler = this;
    }
    private static final Logger logger;
    private static final ArrayList<WebSocketSession> users;

    static {
        users = new ArrayList<>();
        logger = LoggerFactory.getLogger(MyWebSocketHandler.class);
    }
    private Integer custId;


    /**
     * webscoket建立好链接之后的处理函数
     * @param session 当前websocket的会话id，打开一个websocket通过都会生成唯一的一个会话，可以通过该id进行发送消息到浏览器客户端
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        users.add(session);
        custId = (Integer) session.getAttributes().get("custId");
        if (custId != null) {
            MessageExample messageExample=new MessageExample();
            messageExample.createCriteria().andToIdEqualTo(custId).andMessageStatusEqualTo(0);
            List<Message> messages=this.messageDao.selectByExample(messageExample);
            if(messages.size()!=0){
                //有未读消息
                Map<String,Object> data=new HashMap<>(1);
                data.put("message",messages);
                session.sendMessage(new TextMessage(JSON.toJSONString(ServerResponse.createByOffline("取得未读消息!",data))));
            }
        }
    }
    /**
     * 客户端发送服务器的消息时，的处理函数，在这里收到消息之后可以分发消息
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        this.messageDao.updateStatusByCustId((Integer) session.getAttributes().get("custId"));
        record.put(custId.toString(),true);
    }

    /**
     * 消息传输过程中出现的异常处理函数
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // TODO Auto-generated method stub
        if(session.isOpen()){
            session.close();
        }
        System.out.println("websocket connection closed......");
        users.remove(session);
    }


    /**
     * websocket链接关闭的回调
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("websocket connection closed......");
        users.remove(session);
    }

    /**
     * 是否支持处理拆分消息，返回true返回拆分消息
     */
    @Override
    public boolean supportsPartialMessages() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            System.out.println(user.getAttributes().get("custNick"));
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param custId
     * @param message
     */
    public void sendMessageToUser(Integer custId, TextMessage message) {
        /*写入数据库*/
        Boolean flag=true;
        ServerResponse serverResponse=JSON.parseObject(message.getPayload(),ServerResponse.class);
        Message message1=JSON.parseObject(String.valueOf(serverResponse.getData().get("message")),Message.class);
        MessageExample messageExample=new MessageExample();
        messageExample.createCriteria().andFromIdEqualTo(message1.getFromId()).andToIdEqualTo(message1.getToId()).andMessageTextEqualTo(message1.getMessageText()).andMessageStatusEqualTo(0);
        if(myWebSocketHandler.messageDao.selectByExample(messageExample).size()==0){
            myWebSocketHandler.messageDao.insertSelective(message1);
            flag=false;
        }
        if(users.size()!=0){
            for(WebSocketSession user : users){
                if(user.getAttributes().get("custId").equals(custId)){
                    try {
                        if (user.isOpen()) {
                            if(!flag){
                                user.sendMessage(message);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }


    }


}
