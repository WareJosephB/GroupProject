import React, { Component } from 'react';
import './App.css';
import ReactDOM from 'react-dom';

import { makeAccountURL, Header, FirstName, LastName, Submit } from './const.jsx';

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
    Axios.post(makeAccountURL, {
      firstName: document.getElementById('txtFName').value,
      lastName: document.getElementById('txtLName').value
    })
      .then((response) => {
        console.log(response.data);
        this.setState({
          accountNumber: response.data.accountNumber
        });
        ReactDOM.render(<Page2 account={this.state.accountNumber} />, document.getElementById('page2'));
      });
  }

  validateForm = () => {
    var fName = document.forms["theForm"]["txtFName"];
    var lName = document.forms["theForm"]["txtLName"]
    var reC = (/^[a-zA-Z]+$/);
    if (fName.value === "" || !(fName.value.match(reC))) {
      window.alert("Enter Valid First Name")
      return false;
    }
    if (lName.value === "" || !(lName.value.match(reC))) {
      window.alert("Enter Valid Last Name")
      return false;
    } else {
      return true;
    }
  }

  addPerson = () => {
    if (this.validateForm() === true) {
      this.createAccount();
    }
  }

  render() {
    return (
      <div className="App" id="page2">
        <h3>{Header}</h3>
        <br />
        <form name="theForm">
          {FirstName}
          <br />
          <input id="txtFName" type="text"
          placeholder={FirstName} />
          <br />
          {LastName}
          <br />
          <input id="txtLName" type="text"
            placeholder={LastName} />
        </form>
        <button className="btn btn-success" onClick={this.addPerson} >{Submit}</button>
      </div>
    );
  }
}
