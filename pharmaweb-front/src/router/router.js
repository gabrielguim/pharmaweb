import React from 'react';
import { Route } from 'react-router-dom';
import * as routes from './routes';

import LandingPage from '../components/landing/landing';
import HomePage from '../components/home/home';

// Stateless component to making the App.js more clear,
// without using many, many and... many
// of <Route /> tags for all app's routes
const Router = () =>
  <div>
    <Route
      exact
      path={routes.LANDING}
      component={() => <LandingPage />}
    />
    <Route
      exact
      path={routes.HOME}
      component={() => <HomePage />}
    />
  </div>

export default Router;
