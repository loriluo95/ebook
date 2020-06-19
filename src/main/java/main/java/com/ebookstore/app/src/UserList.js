import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class UserList extends Component {

  constructor(props) {
    super(props);
    this.state = {users: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('api/users')
      .then(response => response.json())
      .then(data => this.setState({users: data, isLoading: false}));
  }

  render() {
    const {users, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const userList = users.map(user => {
      return <tr key={user.userId}>
        <td style={{whiteSpace: 'nowrap'}}>{user.userId}</td>
        <td style={{whiteSpace: 'nowrap'}}>{user.username}</td>
        <td style={{whiteSpace: 'nowrap'}}>{user.password}</td>
       </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <h3>Users</h3>
          <Table className="mt-4">
            <thead>
            <tr>
              <th width="20%">UserId</th>
              <th width="20%">Username</th>
              <th width="20%">Password</th>
            </tr>
            </thead>
            <tbody>
            {userList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default UserList;