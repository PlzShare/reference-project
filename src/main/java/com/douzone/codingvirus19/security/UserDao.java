package com.douzone.codingvirus19.security;

import org.springframework.stereotype.Repository;

import com.douzone.codingvirus19.vo.UserVo;

@Repository
public class UserDao {
	public UserVo get(String email) {
		UserVo vo = new UserVo();
		vo.setName("이정은");
		vo.setNo(1L);
		vo.setEmail("aaa");
		vo.setPassword("1234");
		vo.setRole("ROLE_USER");
		return vo;
	}
}
