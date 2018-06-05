import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import withAuthentication from '../../session/withAuthentication';

import Navigation from '../navigation/navigation';

const App = () =>
  <BrowserRouter>
    <Navigation />
  </BrowserRouter>

export default withAuthentication(App);
