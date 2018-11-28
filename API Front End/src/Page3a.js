import React, { Component } from 'react';
import { currency } from './const.jsx';

export default class Page3a extends Component {
  render() {
    return (
      <div>
        <h2>{this.props.message} {currency}</h2>
      </div>
    );
  }
}
