import React from 'react';

import { withStyles } from '@material-ui/core/styles';

import homeStyle from './home-style'
import Router from '../../router/auth-router'
import withAuthorization from '../../session/withAuthorization';

import PAppBar from './app-bar/app-bar'

class Home extends React.Component {

  render() {
    const { classes } = this.props;

    return (
      <div className={classes.root}>
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
