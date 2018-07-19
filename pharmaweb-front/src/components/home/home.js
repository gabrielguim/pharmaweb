import React from 'react';

import { withStyles } from '@material-ui/core/styles';

import homeStyle from './home-style'
import Router from '../../router/auth-router'
import withAuthorization from '../../session/withAuthorization';
import { messaging } from '../../firebase/firebase';

import axios from 'axios';

import PAppBar from './app-bar/app-bar'

class Home extends React.Component {

  requestPermission() {
    messaging.doRequestPermission()
      .then(() => {        
        messaging.doGetToken()
          .then((currentToken) => {
            const fullName = localStorage.getItem('U');
            const email = localStorage.getItem('M');
            const uid = localStorage.getItem('I');
            const token = localStorage.getItem('F');
            const data = {
              'fullName': fullName,
              'email': email,
              'uid': uid,
              'registrationToken': currentToken
            };            

            const headers = {
              headers: {
                'Content-Type': 'application/json',
                'token': token,
                'uid': uid
              }
            };

            axios.put('http://localhost:8081/api/customers/' + uid, data, headers);

          })
      })
  }

  render() {
    const { classes } = this.props;

    return (
      <div className={classes.root}>
        { this.requestPermission() }
        <PAppBar />
        <main className={classes.content}>
          <div className={classes.toolbar} />
          <Router />
        </main>
      </div>
    );
  }
}

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(withStyles(homeStyle, { withTheme: true })(Home));
