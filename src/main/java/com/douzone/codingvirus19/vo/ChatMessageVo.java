package com.douzone.codingvirus19.vo;

public class ChatMessageVo {
	private String nickname;
	private String message;
	private Integer group_no;
	
	public ChatMessageVo() {
		
	}
	
	public ChatMessageVo(String message, String nickname, Integer group_no) {
		this.message = message;
		this.nickname = nickname;
		this.group_no = group_no;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGroup_no() {
		return group_no;
	}

	public void setGroup_no(Integer group_no) {
		this.group_no = group_no;
	}

	@Override
	public String toString() {
		return "ChatMessageVo [nickname=" + nickname + ", message=" + message + ", group_no=" + group_no + "]";
	}


}
