package com.douzone.codingvirus19.vo;

public class AuthVo {
	private Long gNo;
	private Long uNo;
	private int grade;

	public Long getgNo() {
		return gNo;
	}

	public void setgNo(Long gNo) {
		this.gNo = gNo;
	}

	public Long getuNo() {
		return uNo;
	}

	public void setuNo(Long uNo) {
		this.uNo = uNo;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "AuthVo [gNo=" + gNo + ", uNo=" + uNo + ", grade=" + grade + "]";
	}

}
