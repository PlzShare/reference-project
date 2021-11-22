package com.douzone.codingvirus19.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
//	@Autowired
//	SocketHandler socketHandler;
	// Bean을 자동으로 주입하기 위해서 사용하는데, socketHandler와 "/chatting"경로를 addHandler로 담는다.
	// 위의 방식의 경우 @Component 및 @Bean registry.addHandler의 경로를 쉽게 받을 수 있다.
	
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		//registry.addHandler(socketHandler, "/chatting");
//		registry.addHandler(socketHandler, "/chat");
//		registry.addHandler(socketHandler, "/Editor");
//	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");//sub용 sub topic/public
		registry.setApplicationDestinationPrefixes("/app");
		
		System.out.println("웹 소켓 메세지 보커 들어 왔습니다.");
        //메시지 보낼 url send /app/message
		
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
		System.out.println("웹 소켓 config 들어 왔습니다.");
        // URL//chatting  <-웹소켓 연결 주소
	}
}
