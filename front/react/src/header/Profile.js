import React from "react";
export default class Profile extends React.Component {
  render() {
    return (
      <div className="popup-profile" onClick={this.props.closePopup}>
        <div
          className="popup-profile_inner"
          onClick={(e) => e.stopPropagation()}
        >
          <div className="inner_profile-header">
            <h1 className="profile_h1">프로필 정보</h1>
          </div>
          <div className="inner_form-container">
            <input
              className="profile_input"
              type="text"
              placeholder="아이디"
              name="id"
              id="id"
            ></input>
            <input
              className="profile_input"
              type="password"
              placeholder="비밀번호"
              name="password1"
              id="password1"
            ></input>
            <input
              className="profile_input"
              type="password"
              placeholder="비밀번호 확인"
              name="password2"
              id="password2"
            ></input>
            <input
              className="profile_input"
              type="text"
              placeholder="닉네임"
              name="nickname"
              id="nickname"
            ></input>
            <input
              className="profile_input"
              type="email"
              placeholder="이메일"
              name="email"
              id="email"
            ></input>
            <div className="profile_btns">
              <button className="profile_confirm-btn">수정</button>
              <button
                className="profile_cancel-btn"
                onClick={this.props.closePopup}
              >
                취소
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
