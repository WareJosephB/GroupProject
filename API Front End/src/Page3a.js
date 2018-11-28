import React, { Component } from 'react';
import { currency } from './const.jsx';

export default class Page3a extends Component {
  render() {
    return (
      <div>
        <p>{this.props.message} {currency}</p>
      </div>
    );
  }
}
