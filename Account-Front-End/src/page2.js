import React, { Component } from 'react';
import ReactDOM from 'react-dom';

import { checkWinnerURL, makeAccountSuccessString , yourAccountNumber, EnterDraw, Loser, messageDetails} from './const.jsx';

import Page3a from './page3a';
import Page3b from './page3b';
import Axios from 'axios';

export default class Page2 extends Component {

    checkPrize = (event) => {
        event.preventDefault();
        Axios.get(checkWinnerURL + this.props.account)
            .then((response) => {
                if (response.data.winner) {
                    ReactDOM.render(<Page3a message={response.data.prize} />, document.getElementById("page3"))
                } else {
                    ReactDOM.render(<Page3b message={Loser} />, document.getElementById("page3"))
                }
            });
    }
    render() {
        return (
            <div className="App" id="page3">
                <h1>{makeAccountSuccessString}</h1> <br/>
                <h2>{yourAccountNumber}</h2> <br/>
                <h1>{this.props.account}</h1>
                <button className="btn btn-success" onClick={this.checkPrize} >{EnterDraw}</button>
            </div>
        );
    }
}
