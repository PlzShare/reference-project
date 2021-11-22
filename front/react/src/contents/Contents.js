import React from "react";
import ContentsHeader from "./ContentsHeader";
import ContentsMemo from "./ContentsMemo";

export default class Contents extends React.Component {
  render() {
    return (
      <div className="contents">
        <ContentsHeader />
        <ContentsMemo />
      </div>
    );
  }
}
