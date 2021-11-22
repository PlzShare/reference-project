package com.douzone.codingvirus19.vo;

public class UserVo {
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	private Long no;
	private String id;
	private String email;
	private String password;
	private String nickname;
	private String image;
	private String name;
	private String role;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", email=" + email + ", password=" + password + ", nickname="
				+ nickname + ", image=" + image + ", name=" + name + "]";
	}

}
