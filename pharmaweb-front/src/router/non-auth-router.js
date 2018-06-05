import React from 'react';
import { Route, Switch } from 'react-router-dom';

import SignIn from '../components/sign-in/sign-in';
import SignUp from '../components/sign-up/sign-up';

// Stateless component to making the App.js more clear,
// without using many, many and... many
// of <Route /> tags for all app's routes
const AuthRouter = () =>
  <Switch>
    <Route exact path="/" component={SignIn}/>
    <Route exact path="/sign-in" component={SignIn}/>
    <Route exact path="/sign-up" component={SignUp}/>
    <Route exact path="/**" component={SignIn}/>
  </Switch>

export default AuthRouter;
