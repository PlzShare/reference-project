import React from "react";

export default class ContentsHeader extends React.Component {
  render() {
    return (
      <div className="contents-header">
        <div className="contents-header-title">
          <h3>{`< 개인1 >`}</h3>
        </div>
        <div className="contents-header-showinglist">
          <button className="contents-header__btns">
            <i className="fas fa-bars"></i>
          </button>
        </div>
        <div className="contents-header-addgroup">
          <button className="contents-header__btns">
            <i className="fas fa-folder-plus"></i>
          </button>
        </div>
        <div className="contents-header-invite">
          <button className="contents-header__btns">
            <i className="fas fa-user-plus"></i>
          </button>
        </div>
      </div>
    );
  }
}
