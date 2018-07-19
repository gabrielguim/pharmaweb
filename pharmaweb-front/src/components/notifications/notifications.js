import React from "react";
import withAuthorization from '../../session/withAuthorization';

import NotificationList from './notification-list';

class Notifications extends React.Component {
  render() {
    return (
      <NotificationList />
    );
  }
}

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(Notifications);
