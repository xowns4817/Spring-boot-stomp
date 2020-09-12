package com.example.websocket.demo.controller;

import com.example.websocket.demo.model.Greeting;
import com.example.websocket.demo.model.RoomMessage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // 채팅
    @MessageMapping("/chat/{roomId}") // 클라로 부터 메시지가 들어오는 라우터
    @SendTo("/topic/chat/{roomId}") // 구독 관련된 라우터
    public Greeting chat(@DestinationVariable String roomId, RoomMessage message) throws Exception {
        return new Greeting("roomId : " + roomId +  " - " +
                            " from : " + message.getUserId() + " -  " +
                            "message : " + message.getMsg());
    }

    // 입장
    @MessageMapping("/in/{roomId}/{userId}")
    @SendTo("/topic/in/{roomId}") // 구독 관련된 라우터
    public String roomIn (@DestinationVariable String roomId,
                          @DestinationVariable String userId) throws Exception {
        return "roomId : " + roomId  + " " + userId + " 님이 입장하셨습니다.";
    }

    // 퇴장
    @MessageMapping("/out/{roomId}/{userId}")
    @SendTo("/topic/out/{roomId}") // 구독 관련된 라우터
    public String roomOut (@DestinationVariable String roomId,
                           @DestinationVariable String userId) throws Exception {
        return "roomId : " + roomId + " " + userId + " 님이 퇴장하셨습니다.";
    }
}
