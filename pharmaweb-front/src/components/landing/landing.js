import React from 'react';
import withAuthorization from '../../session/withAuthorization';

const Landing = () =>
  <div>
    Landing
  </div>

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(Landing);
