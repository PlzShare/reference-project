package com.douzone.codingvirus19.vo;

public class HashVo {
	private Long no;
	private Long mNo;
	private Long gNo;
	private String name;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getmNo() {
		return mNo;
	}

	public void setmNo(Long mNo) {
		this.mNo = mNo;
	}

	public Long getgNo() {
		return gNo;
	}

	public void setgNo(Long gNo) {
		this.gNo = gNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HashVo [no=" + no + ", mNo=" + mNo + ", gNo=" + gNo + ", name=" + name + "]";
	}

}
