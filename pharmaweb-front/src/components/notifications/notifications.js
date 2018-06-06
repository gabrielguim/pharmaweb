import React from "react";
import withAuthorization from '../../session/withAuthorization';

class Notifications extends React.Component {
  render() {
    return (
      <div>
        NOTIFICAÇÕES
      </div>
    );
  }
}

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(Notifications);
