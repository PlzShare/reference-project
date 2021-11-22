package com.douzone.codingvirus19.vo;


public class AlarmVo {
	private Long no;
	private Long gNo;
	private Long uNo;
	private String chat;
	private String date;
	private String memo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

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

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "AlarmVo [no=" + no + ", gNo=" + gNo + ", uNo=" + uNo + ", chat=" + chat + ", date=" + date + ", memo="
				+ memo + "]";
	}

}
