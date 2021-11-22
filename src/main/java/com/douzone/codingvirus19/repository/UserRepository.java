package com.douzone.codingvirus19.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.codingvirus19.vo.UserVo;


@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean login(UserVo vo) { 
		return  sqlSession.selectOne("user.login",vo);
	}

//	public void update(MainVo vo) {
//		System.out.println("Repository"+vo);
//		sqlSession.update("main.update",vo);
//	}

	public UserVo findByIdAndPassword(UserVo vo) {
		System.out.println("Repository vo" + vo);
		UserVo authUser = sqlSession.selectOne("user.findByIdAndPassword", vo);
		System.out.println("Repository: " + authUser);
		return authUser;
	}

	public void joinInsert(UserVo vo) {
		sqlSession.insert("user.joinInsert", vo);
		
	}
	

}
