import React, { Component } from 'react';
import './App.css';
import ReactDOM from 'react-dom';

import { makeAccountURL, Header, FirstName, LastName, Submit} from './const.jsx';

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
      lastName : document.getElementById('txtLName').value
    })
      .then((response) => {
        console.log(response.data);
        this.setState({
          accountNumber: response.data.accountNumber
        });
        ReactDOM.render(<Page2 account={this.state.accountNumber} />, document.getElementById('page2'));
      });
  }

  render() {
    return (
      <div className="App" id="page2">
        <h3>{Header}</h3>
        <br />
        <form>
        {FirstName}<br />
        <input type="text" id="txtFName" required='true'></input>
        <br /><br />
        {LastName}<br />
        <input type="text" id="txtLName" Required></input>
        <br /><br />
        </form>
        <button className="btn btn-success" onClick={this.createAccount} >{Submit}</button>
      </div>
    );
  }
}