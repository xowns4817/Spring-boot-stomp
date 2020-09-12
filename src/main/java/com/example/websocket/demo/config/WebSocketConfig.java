package com.example.websocket.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @EnableWebSocketMessageBroker : Websocket 서버를 활성화 시킨다.
 * WebSocketMessageBrokerConfigurer : 웹 소켓 연결을 구성하기 위한 메서드를 구현하고 제동한다.
 * registerStompEndpoints : 클라이언트가 웹 소켓 서버에 연결하는데 사용할 웹 소켓 엔드 포인트를 제공한다.
 * configureMessageBroker : 한 클라이언트에서 다른 클라이언트로 메세지를 라우팅 하는데 사용될 메시지 브로커를 구성하고 있다.
 * registry.setApplicationDestinationPrefixes("/app"); -> "/app" 시작되는 메시지가 message-handling methods으로 라우팅 되어야 한다는 것을 명시한다.
 * registry.enableSimpleBroker("/topic"); -> "/topic" 시작되는 메시지가 메시지 브로커로 라우팅 되로록 정의한다. 메시지는 특정 주제를 구독한 연결된 모든 클라이언트에게 메시지를 broadcast한다.
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); // 클라가 보내는 주소.
        registry.enableSimpleBroker("/topic");
    }
}