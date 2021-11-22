import React from "react";
import Dropdown from "react-bootstrap/Dropdown";
import Profile from "./Profile";

export default class HeaderProfile extends React.Component {
  constructor() {
    super();
    this.state = {
      showPopup: false,
    };
  }
  togglePopup() {
    this.setState({
      showPopup: !this.state.showPopup,
    });
  }
  render() {
    return (
      <Dropdown className="header-profile">
        <Dropdown.Toggle
          className="header-profile__icon"
          variant="success"
          id="dropdown-basic"
        >
          <i className="fas fa-user"></i>
          <img src="" />
        </Dropdown.Toggle>

        <Dropdown.Menu className="dropdown-menu">
          <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
          <Dropdown.Item
            href="#/action-2"
            onClick={this.togglePopup.bind(this)}
          >
            개인프로필 수정
          </Dropdown.Item>
          <Dropdown.Item href="#/action-3">로그아웃</Dropdown.Item>
        </Dropdown.Menu>
        {this.state.showPopup ? (
          <Profile closePopup={this.togglePopup.bind(this)} />
        ) : null}
      </Dropdown>
    );
  }
}
