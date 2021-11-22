import React from "react";

export default class sidebar extends React.Component {
  render() {
    return (
      <div className="sidebar">
        <ul>
          <li>
            <a>개인메모</a>
            <div>
              <h6>Hashtag</h6>
              <a>해쉬테그</a>
              <a>해쉬테그2</a>
            </div>
          </li>
          <li>
            그룹메모
            <div>
              <h6>Hashtag</h6>
              <a>해쉬테그</a>
            </div>
            <div>
              <h6>Group</h6>
              <a>그룹1.</a>
              <a>그룹2.</a>
            </div>
          </li>
        </ul>
      </div>
    );
  }
}
