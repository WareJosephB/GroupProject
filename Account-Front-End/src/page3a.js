import React, { Component } from 'react';
import { currency, Winnner } from './const.jsx';

export default class Page3a extends Component {
  render() {
    return (
      <div>
        <h2> {Winnner} {this.props.message} {currency}</h2>
      </div>
    );
  }
}
