package com.douzone.codingvirus19.vo;

public class ChatVo {
	private Long gNo;
	private Long uNo;
	private String message;
	private String date;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ChatVo [gNo=" + gNo + ", uNo=" + uNo + ", message=" + message + ", date=" + date + "]";
	}

}
