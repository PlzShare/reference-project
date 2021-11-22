import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Join from './User/Join';
import Login from './User/Login';
import Container from './Container';
import NotFound from './NotFound';

export default class Router1 extends React.Component {

  render() {
    return (
      <Router>
        <Route path="/" component={Login }/>
        <Route path="/main" component={Container}/>
        <Route path="/join" component={Join}/>
      </Router>
      // <Router> 
      //   <Switch>
      //     <Route exact path="/login" >
      //       <Login/>
      //     </Route>
      //     <Route path="/main">
      //       <Container/>
      //     </Route>
      //     </Switch>
      // </Router>
    );
  }
}
