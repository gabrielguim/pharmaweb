import React from 'react';

import AuthUserContext from './auth-user-context';
import { firebase } from '../firebase/firebase';

const withAuthentication = (Component) =>
  class WithAuthentication extends React.Component {
    constructor(props) {
      super(props);

      this.state = {
        authUser: null,
      };
    }

    componentDidMount() {
      firebase.auth.onAuthStateChanged(authUser => {

        if (authUser) {
          authUser.getIdToken().then(function(data) {
            const uid = authUser.uid;
            const token = data;

            localStorage.setItem('I', uid);
            localStorage.setItem('F', token);

          });
        }

        authUser
          ? this.setState(() => ({ authUser }))
          : this.setState(() => ({ authUser: null }));
      });
    }

    render() {
      const { authUser } = this.state;

      return (
        <AuthUserContext.Provider value={authUser}>
          <Component />
        </AuthUserContext.Provider>
      );
    }
  }

export default withAuthentication;
