package com.douzone.codingvirus19.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.codingvirus19.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		//1. handler 종류 확인
		if(handler instanceof HandlerMethod == false) {
			// asset 접근 DefaultServletHandler가 처리하는 경우(보퉁, assets의 정적 자원 접근)
			return true;
		}
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3.Method @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		
		
		//4.Method에 @Auth가 없으면,,,, Type에 붙어 있는 지 확인한다(과제)
		if(auth == null) {
			//auth = <--
			System.out.println(handlerMethod.getReturnType());
			auth = handlerMethod.getReturnType().getDeclaringClass().getAnnotation(Auth.class);
		}

		//5. Type이나 Method 둘 다 @Auth가 적용이 안되어 있는 경우,
		if(auth == null) {
			return true;
		}
			
		//6. 인증 여부 확인(@Auth가 붙어 있기 때문)
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		//6. 권한(Authorization) 체크를 위해서 @Auth의 role 가져오기("USER","ADMIN")
		String role = auth.value();
		System.out.println("role:"+ role);

		//7. @Auth의 role이 "USER" 인 경우에는  
		//   authUser의 role이 "USER" 이든 "ADMIN" 상관이 없음.
		if("USER".equals(role)) {
			return true;
		}else if("ADMIN".equals(authUser.getRole())==false) {			//8. @Auth의 role이 "ADMIN" 인 경우에는 반드시 authUser의 role이 "ADMIN" 여야 한다.
			response.sendRedirect(request.getContextPath());
			return false;
		}
		// @Auth의 role => "ADMIN"
		// authUser의 role => "ADMIN"
		// 관리자 권한으로 실행
		return true;
		
		
	}
	
}
