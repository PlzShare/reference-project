import React from "react";

function NotFound({ match }) {
  return (
    <div className="notFound">
      Not Found <br/>url:{match.url}
    </div>
  );
}
export default NotFound