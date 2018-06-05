import React from 'react';

import { withStyles } from '@material-ui/core/styles';

import AuthUserContext from '../../session/auth-user-context';
import Home from '../home/home'
import homeStyle from '../home/home-style'
import AuthRouter from '../../router/non-auth-router'

const Navigation = (props) =>
  <AuthUserContext.Consumer>
    {authUser => authUser
      ? <NavigationAuth />
      : <NavigationNonAuth { ... props } />
    }
  </AuthUserContext.Consumer>

const NavigationAuth = () =>
  <div>
    <Home />
  </div>

const NavigationNonAuth = (props) =>  {
  const { classes } = props;

  return (
    <div className={classes.root}>
      <main className={classes.content}>
        <div className={classes.toolbar} />
        <AuthRouter />
      </main>
    </div>
  );
}


export default withStyles(homeStyle, { withTheme: true })(Navigation);
