import React from "react";
import Dropdown from "react-bootstrap/Dropdown";

export default class Userbell extends React.Component {
  render() {
    return (
      <Dropdown className="header-bell">
        <Dropdown.Toggle
          className="header-bell__icon"
          variant="success"
          id="dropdown-basic"
        >
          <i className="fas fa-bell"></i>
          <img src="" />
        </Dropdown.Toggle>

        <Dropdown.Menu className="dropdown-menu">
          <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
          <Dropdown.Item href="#/action-2">알림1</Dropdown.Item>
          <Dropdown.Item href="#/action-3">알림2</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
    );
  }
}
