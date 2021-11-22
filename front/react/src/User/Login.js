import React from "react";
import Container from "../Container";
import { BrowserRouter as Router, Route, Switch, Link, Redirect } from 'react-router-dom';
import Router1 from "../Router1";

const API_URL = "http://localhost:8080/codingvirus19";
const API_HEADERS = {
  "Content-Type": "application/json",
};
export default class login extends React.Component {
  constructor() {
    super(...arguments);
    this.state = {
      id: "",
      password: "",
      result: false,
    };
  }

  IdChange(e) {
    this.setState({
      id: e.target.value,
    });
  }

  PassWordChange(e) {
    this.setState({
      password: e.target.value,
    });
  }

  Login() {
    const formData = new FormData();
    formData.append("id", this.state.id);
    formData.append("password", this.state.password);
    console.log(formData);
    fetch(`${API_URL}/user/auth`, {
      method: "post",
      body: formData,
    })
      .then((response) => console.log(response))
      .then((json) => {
        console.log(json);
        // this.setState({
        //   result: json.data,
        // });
        
      })
      .catch((err) => console.error(err));
  }
  
  render() {
    console.log(this.state.result);
    if(this.state.result === true){
      return(
        <Redirect to="/main" />
      );
    }
    return (
      <div className="App">
        <div className="auth-wrapper">
          <div className="auth-inner">
            <form>
              <h3>로그인</h3>

              <div className="form-group">
                <label>아이디/이메일</label>
                <input
                  type="email"
                  className="form-control"
                  value={this.state.id}
                  onChange={this.IdChange.bind(this)}
                  type="text"
                  placeholder="아이디/이메일"
                />
              </div>

              <div className="form-group">
                <label>비밀번호</label>
                <input
                  type="password"
                  className="form-control"
                  value={this.state.password}
                  onChange={this.PassWordChange.bind(this)}
                  type="password"
                  placeholder="비밀번호"
                />
              </div>

              <div className="form-group">
                <div className="custom-control custom-checkbox">
                  <input
                    type="checkbox"
                    className="custom-control-input"
                    id="customCheck1"
                  />
                  <label
                    className="custom-control-label"
                    htmlFor="customCheck1">
                    아이디 저장하기
                  </label>
                </div>
              </div>
              <div>
                <div onClick={this.Login.bind(this)}> 로그인</div>
              </div>
              <p className="forgot-password text-right">
                아이디가 없으신가요?<a href="/join"> 회원가입하기</a>
              </p>
            </form>
          </div>
        </div>
      </div>
    );
  }
}
