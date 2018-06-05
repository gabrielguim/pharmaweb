import React from "react";
import withAuthorization from '../../session/withAuthorization';
import { firebase } from '../../firebase/firebase';

class Notifications extends React.Component {

  getUserToken = () => {
    firebase.auth.onAuthStateChanged(authUser => {
      authUser.getIdToken().then(function(data) {
        console.log(data);
      });
    });
  }

  render() {
    this.getUserToken();

    return (
      <div>
        NOTIFICAÇÕES
      </div>
    );
  }
}

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(Notifications);
