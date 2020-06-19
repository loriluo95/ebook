import React, { Component } from 'react';
//import logo from './logo.svg';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Home from './Home';

import UserList from './UserList';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/users' exact={true} component={UserList}/>
        </Switch>
      </Router>
    )
  }
}
//class App extends Component {
//    state = {
//        isLoading: true,
//        users: []
//    }
//    async componentDidMount() {
//    const response = await fetch('/api/users');
//    const body = await response.json();
//    this.setState({ users: body, isLoading: false });
//  }
//
//  render() {
//    const {users, isLoading} = this.state;
//
//    if (isLoading) {
//      return <p>Loading...</p>;
//    }
//
//    return (
//      <div className="App">
//        <header className="App-header">
//          <img src={logo} className="App-logo" alt="logo" />
//          <div className="App-intro">
//            <h2>EBook: User List</h2>
//            {users.map(user =>
//              <div key={user.userId}>
//                {user.username}
//              </div>
//            )}
//          </div>
//        </header>
//      </div>
//    );
//  }
//}


export default App;
