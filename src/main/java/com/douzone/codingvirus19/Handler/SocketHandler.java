package com.douzone.codingvirus19.Handler;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// 밑의 @Component 어노테이션을 통해서 Class를 Bean으로 등록 해 줌
@Component
public class SocketHandler extends TextWebSocketHandler {

	HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 해시맵
	
	@Override
	public void handleTextMessage(WebSocketSession session, final TextMessage message) {
		//메시지 발송
		final String msg = message.getPayload();
		for(final String key : sessionMap.keySet()) {
			//sessionMap.keySet()은 Map의 전체 값을 뽑아내기 위함 즉, sessionMap의 값만 뽑아내서 WebSocketSession에 담음.
			session = sessionMap.get(key);
			try {
				// 담은 세션에 msg를 담음 msg는 JS에서 보낸 (이름이나 채팅 내용 등, 전체 내용)String을 session을 통해 보냄
				session.sendMessage(new TextMessage(msg));
			}catch(final Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
		// 소켓 연결
		// Map에 session의 id와 시작 session 담기
		// 생성된 세션을 저장하면 발신메시지 타입은 getId라고 명시 후 생성된 세션ID값을 클라이언트 단으로 발송
		// 클라이언트 단에서는 type값을 통해 메시지와 초기 설정값을 구분.
		sessionMap.put(session.getId(), session);
		
		// String을 Json객체 형식으로 바꿔서 client단으로 보냄
		final JSONObject object = new JSONObject();
		object.put("type", "getId");
		object.put("peopleId", session.getId());
		session.sendMessage(new TextMessage(object.toJSONString()));
	}
	
	@Override
	public void afterConnectionClosed(final WebSocketSession session, final CloseStatus status) throws Exception {
		// 소켓 종료
		// Map에 session의 session 취소 시키기
		sessionMap.remove(session.getId());
	}
	
	// JSONParser을 사용하여 파싱
	// 메시지 전송시 JSON파싱을 위해서 message.getPayload()를 통해 받은 문자열을 만든 함수 jsonToObjectParser
	// jsonToObjectParser 넣어서 JSONObject값으로 받아서 강제 문자열 형태로 보냄
	private static JSONObject jsonToObjectParser(final String jsonStr) {
		final JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(jsonStr);
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
