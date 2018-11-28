import React, { Component } from 'react';
import './App.css';
import ReactDOM from 'react-dom';

import { makeAccountURL } from './const.jsx';

import Page2 from './page2';
import Axios from 'axios';

export default class App extends Component {
  constructor(props) {
    super(props);

    this.state =
      {
        accountNumber: ""
      }
  }
  createAccount = (event) => {
    event.preventDefault();
    var account =
    {
      firstName: document.getElementById('txtFName').value,
      lastName: document.getElementById('txtLName').value
    };
    Axios.post(makeAccountURL, { account })
      .then((response) => {
        this.setState({
          accountNumber: response.data.accountNumber
        });
        ReactDOM.render(<Page2 account={this.state.accountNumber} />, document.getElementById('page2'));
      });
  }

  render() {
    return (
      <div className="App" id="page2">
        <h1>Account Creation</h1>
        <h3> Please enter your details </h3>
        <br />
        First Name: <br />
        <input type="text" id="txtFName"></input>
        <br /><br />
        Last Name: <br />
        <input type="text" id="txtLName"></input>
        <br /><br />
        <button className="btn btn-success" onClick={this.createAccount} >Submit</button>
      </div>
    );
  }
}