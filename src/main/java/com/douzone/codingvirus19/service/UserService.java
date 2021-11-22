package com.douzone.codingvirus19.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.codingvirus19.repository.UserRepository;
import com.douzone.codingvirus19.vo.UserVo;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public boolean login(UserVo vo) {
		return userRepository.login(vo);
	}

	public UserVo findByIdAndPassword(UserVo vo) {
		System.out.println("Service vo" + vo);
		UserVo authUser = userRepository.findByIdAndPassword(vo);
		System.out.println("Service: " + authUser);
		return authUser;
	}

	public void joinInsert(UserVo vo) {
		userRepository.joinInsert(vo);
	}


}
