import React from "react";
import Popup from "./Popup";

export default class HeaderAddMemo extends React.Component {
  constructor() {
    super();
    // 기본속성 showPopup의 값을 false로 추가
    this.state = {
      showPopup: false,
    };
    console.log(this.state);
  }
  // togglePopup 메소드 실행 시 showPopup이 true로 변환된다.
  togglePopup() {
    this.setState({
      showPopup: !this.state.showPopup,
    });
  }

  render() {
    return (
      // 추가 버튼 클릭 시 showPopup이 true가 된다.
      <div className="header-addmemo">
        <button
          className="header-memo_btn"
          onClick={this.togglePopup.bind(this)}
        >
          <i className="fas fa-plus"></i>
        </button>

        {/* 만약 show Pop이 true라면 Popup component가 실행되면서 속성값을 closePopup속성값을 전달해준다. */}
        {this.state.showPopup ? (
          <Popup closePopup={this.togglePopup.bind(this)} />
        ) : null}
      </div>
    );
  }
}
