import React from 'react';

import listItemsStyle from './list-items-style'

import { withStyles } from '@material-ui/core/styles';

import LinearProgress from '@material-ui/core/LinearProgress';
import Fade from '@material-ui/core/Fade';
import CustomList from './custom-list';

import axios from 'axios';

class ListItems extends React.Component {

  state = {
      token: '',
      value: 0,
      list: [],
      loading: false
  };

  linearProgress = () => {
    const { loading } = this.state;
    return (
      <div className={this.props.classes.loadingProgress}>
        <Fade
          in={loading}
          style={{
            transitionDelay: loading ? '200ms' : '200ms',
          }}
          unmountOnExit>
          <LinearProgress color="secondary" />
        </Fade>
      </div>
    );
  };

  getProducts = (query) => {
    const uid = localStorage.getItem('I');
    const token = localStorage.getItem('F');

    const headers = {
      headers: {
        'Content-Type': 'application/json',
        'token': token,
        'uid': uid
      }
    };

    this.setState({ loading: true });
    axios.get('http://localhost:8081/api/products' + query, headers)
      .then(res => {
        this.setState({ list: res.data,
                        loading: false })
      }).catch(error => {
        this.setState({ loading: false })
        console.log(error);
      });
  };

  componentWillMount = () => {
    this.getProducts(this.props.children ? this.props.children : "");
  }

  render() {
    const { classes } = this.props;

    return (
      <div>
        { this.linearProgress() }
        <div className={classes.root}>
          <CustomList list={this.state.list} { ... this.props } />
        </div>
      </div>
    );
  };

}

export default withStyles(listItemsStyle)(ListItems);
