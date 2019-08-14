package com.training.ordermatching.component;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint("/websocket/{user_name}")
public class WebSocketServer {

    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    private Session session;


    @OnOpen
    public void onOpen(Session session, @PathParam("user_name") String userName) {
        this.session = session;
        webSocketSet.put(userName, this);
        log.info("[WebSocket] connected，the Online user count：={}", webSocketSet.size() + ",the User is ：" + userName);
    }


    @OnClose
    public void OnClose() {
        webSocketSet.remove(this);
        log.info("[WebSocket] disconnected，the Online user count：={}", webSocketSet.size());
    }

    @OnError
    public void onError(Throwable error) {
        log.error("[WebSocket] Error");
        error.printStackTrace();
    }

    @OnMessage
    public void OnMessage(String message) {
        log.info("[WebSocket] receive message：{}", message);
        //GroupSending(message);

    }

    public void groupSending(String message) {
        for (String userName : webSocketSet.keySet()) {
            try {
                webSocketSet.get(userName).session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void appointSending(String userName, String message) {
        try {
            webSocketSet.get(userName).session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
