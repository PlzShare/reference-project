package com.douzone.codingvirus19.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.douzone.codingvirus19.controller.MainController;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Log LOG = LogFactory.getLog(MainController.class);

	@ExceptionHandler(Exception.class)
	public void handleException(HttpServletRequest request, HttpServletResponse response, Exception e)
			throws Exception {

		// 1. 로깅(logging)
		// e.printStackTrace();
		StringWriter errors = new StringWriter(); // 버퍼
		e.printStackTrace(new PrintWriter(errors));
		LOG.error(errors.toString());
		// LOGGER.error(errors.toString());

		// 2. 요청구분
		// 만약, JSON 요청인 경우 request header의Accpet에 apllication/json
		// 만약, html 요청인 경우 request header의Accpet에 text/html
		// 만약, jpeg 요청인 경우 request header의Accpet에 image/jpeg
		String accept = request.getHeader("accept");
		if (accept.matches(".*application/json.*")) {
			// 3.JSON 응답
			response.setStatus(HttpServletResponse.SC_OK);
		} else {

			// 2. 안내페이지 가기(정상종료)
			request.setAttribute("exception", errors.toString());
			request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, response);
		}
	}
}