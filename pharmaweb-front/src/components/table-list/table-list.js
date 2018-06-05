import React from 'react';
import withAuthorization from '../../session/withAuthorization';

const TableList = () =>
  <div>
    TABLE LIST
  </div>

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(TableList);
