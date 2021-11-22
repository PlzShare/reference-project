import React, { Component } from "react";
import ApiService from "../ApiService";

const API_URL = "http://localhost:8080/codingvirus19";
const API_HEADERS = {
  "Content-Type": "application/json",
};

export default class Join extends Component {
  constructor() {
    super(...arguments);
    this.state = {
      id: "",
      email: "",
      password: "",
      passwordChk: "",
      nickname: "",
      name: "",
      image: "",
    };
  }

  // componentDidMount() {
  //   ApiService.fetchJoin().catch((err) => {
  //     console.log("error", err);
  //   });
  // }

  onChangeId(e) {
    this.setState({
      id: e.target.value,
    });
  }
  onChangeNick(e) {
    this.setState({
      nickname: e.target.value,
    });
  }
  onChangeEmail(e) {
    this.setState({
      email: e.target.value,
    });
  }
  onChangePassword(e) {
    this.setState({
      password: e.target.value,
    });
    console.log(this.state.password);
  }
  setPasswordError() {
    console.log("password틀림");
    return;
  }
  //비밀번호를 입력할때마다 password 를 검증하는 함수
  onChangePasswordChk(e) {
    this.setState({
      passwordChk: e.target.value,
    });
  }

  onChangeName(e) {
    this.setState({
      name: e.target.value,
    });
  }
  onChangeImage(e) {
    this.setState({
      image: e.target.value,
    });
  }

  Join() {
    console.log(this.state.password + ":" + this.state.passwordChk);
    if (this.state.passwordChk !== this.state.password) {
      alert("password틀림");
      return;
    }
    let input_date = {
      id: this.state.id,
      email: this.state.email,
      password: this.state.password,
      nickname: this.state.nickname,
      name: this.state.name,
      image: this.state.image,
    };
    console.log(input_date);
    // call api
    fetch(`${API_URL}/api/join`, {
      method: "post",
      headers: API_HEADERS,
      body: JSON.stringify(input_date),
    })
      .then((response) => response.json())
      .then((json) => {
        this.setState({
          result: json.data,
        });
      })
      .catch((err) => console.error(err));
  }

  render() {
    return (
      <div className="join-popup" onClick={this.props.closePopup}>
        <div
          className="join-popup_inner"
          onClick={(e) => {
            e.stopPropagation();
          }}
        >
          <form>
            <h3>회원가입</h3>

            <div className="form-group">
              <label>아이디</label>
              <input
                type="text"
                className="form-control"
                value={this.state.id}
                placeholder="아이디"
                required
                onChange={this.onChangeId.bind(this)}
              />
            </div>

            <div className="form-group">
              <label>닉네임</label>
              <input
                type="text"
                className="form-control"
                value={this.state.nickname}
                placeholder="닉네임"
                required
                onChange={this.onChangeNick.bind(this)}
              />
            </div>

            <div className="form-group">
              <label>이메일</label>
              <input
                type="email"
                className="form-control"
                value={this.state.email}
                placeholder="이메일"
                required
                onChange={this.onChangeEmail.bind(this)}
              />
            </div>

            <div className="form-group">
              <label>비밀번호</label>
              <input
                type="password"
                className="form-control"
                value={this.state.password}
                placeholder="비밀번호"
                required
                onChange={this.onChangePassword.bind(this)}
              />
            </div>

            <div className="form-group">
              <label>비밀번호 재확인</label>
              <input
                type="password"
                className="form-control"
                value={this.state.passwordChk}
                placeholder="비밀번호 재입력"
                required
                onChange={this.onChangePasswordChk.bind(this)}
              />
            </div>
            <div className="form-group">
              <label>이름</label>
              <input
                type="text"
                className="form-control"
                value={this.state.name}
                placeholder="이름 입력"
                required
                onChange={this.onChangeName.bind(this)}
              />
            </div>
            <div className="form-group">
              <label>이미지</label>
              <input
                type="text"
                className="form-control"
                value={this.state.image}
                placeholder="이미지 입력"
                required
                onChange={this.onChangeImage.bind(this)}
              />
            </div>
          </form>
          <div>
            <button
              onClick={this.Join.bind(this)}
              type="submit"
              className="btn btn-primary btn-block"
            >
              가입하기
            </button>
            <p className="forgot-password text-right">
              기존의 아이디가 존재한다면?
              <a onClick={this.props.closePopup} href="/login">
                로그인하기
              </a>
            </p>
          </div>
        </div>
      </div>
    );
  }
}
