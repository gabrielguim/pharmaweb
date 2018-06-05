import React from 'react';
import { withRouter } from 'react-router-dom';

import AuthUserContext from './auth-user-context';
import { firebase } from '../firebase/firebase';

const withAuthorization = (condition) => (Component) => {
  class WithAuthorization extends React.Component {
    componentDidMount() {
      firebase.auth.onAuthStateChanged(authUser => {
        var currentLocation = this.props.location.pathname;

        if (authUser) {
          authUser.getIdToken().then(function(data) {
            const uid = authUser.uid;
            const token = data;

            localStorage.setItem('I', uid);
            localStorage.setItem('F', token);

          });
        }

        if (!condition(authUser)) {
          if (currentLocation === "/sign-up") this.props.history.push("/sign-up");
          else this.props.history.push("/sign-in");
        }
      });
    }

    render() {
      return (
        <AuthUserContext.Consumer>
          {authUser => authUser ? <Component /> : null}
        </AuthUserContext.Consumer>
      );
    }
  }

  return withRouter(WithAuthorization);
}

export default withAuthorization;
