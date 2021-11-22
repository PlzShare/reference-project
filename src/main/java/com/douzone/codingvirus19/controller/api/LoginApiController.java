//package com.douzone.codingvirus19.controller.api;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.douzone.codingvirus19.dto.JsonResult;
//import com.douzone.codingvirus19.service.UserService;
//import com.douzone.codingvirus19.vo.UserVo;
//
//
//@RestController
//@RequestMapping("/api")
//public class LoginApiController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@PostMapping("/login")
//		
//	public JsonResult login(HttpSession httpSession, @RequestBody UserVo vo) {
//
//		System.out.println("Controller vo" + vo);
//		UserVo authUser = userService.findByIdAndPassword(vo);
//		httpSession.setAttribute("authUser", authUser);
//		
//		if(authUser != null) {
//			return JsonResult.success(true);
//		}
//		return JsonResult.success(false);
//	}
//	
//	@PostMapping("/join")
//	public JsonResult join(HttpSession httpSession, @RequestBody UserVo vo) {
//		
//		System.out.println("Controller vo" + vo);
//		userService.joinInsert(vo);
////		
//		
//		return JsonResult.success(true);
//	}
//	
//	
//	
//}
