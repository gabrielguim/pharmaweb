import React from 'react';
import { Route, Switch } from 'react-router-dom';

import Landing from '../components/landing/landing';
import TableList from '../components/table-list/table-list';
import Notifications from '../components/notifications/notifications';
import Cart from '../components/cart/cart';

// Stateless component to making the App.js more clear,
// without using many, many and... many
// of <Route /> tags for all app's routes
const Router = () =>
  <Switch>
    <Route exact path="/" component={Landing}/>
    <Route exact path="/notifications" component={Notifications}/>
    <Route exact path="/products" component={TableList}/>
    <Route exact path="/cart" component={Cart}/>
    <Route exact path="/**" component={Landing}/>
  </Switch>

export default Router;
