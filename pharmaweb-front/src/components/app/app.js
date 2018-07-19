import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import withAuthentication from '../../session/withAuthentication';

import Navigation from '../navigation/navigation';
import { messaging } from '../../firebase/firebase'
import AuthUserContext from '../../session/auth-user-context';

const App = () => 
  <AuthUserContext.Consumer>
    {(context) => {
      messaging.doReceiveMessage(context);

      return (
        <BrowserRouter>
          <Navigation />
        </BrowserRouter>
      )
    }}
  </AuthUserContext.Consumer>

export default withAuthentication(App);
