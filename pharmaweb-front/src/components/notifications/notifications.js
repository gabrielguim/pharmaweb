import React from "react";
import withAuthorization from '../../session/withAuthorization';
import AuthUserContext from "../../session/auth-user-context";


class Notifications extends React.Component {
  render() {
    return (
      <AuthUserContext.Consumer>
        {(context) => {
          // TODO: =D
        }}
      </AuthUserContext.Consumer>
    );
  }
}

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(Notifications);
