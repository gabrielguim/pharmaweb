import React from "react";
import withAuthorization from '../../session/withAuthorization';

import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';

import ListItems from './list-items/list-items'

function TabContainer(props) {
  return (
    <ListItems>
      {props.children}
    </ListItems>
  );
}

class TableList extends React.Component {

  state = {
      token: '',
      value: 0
  };

  handleChange = (event, value) => {
    this.setState({ value });
  };

  handleChangeIndex = index => {
    this.setState({ value: index });
  };

  render() {
    const { value } = this.state;

    return (
      <div>
        <AppBar position="static" color="default">
          <Tabs
            value={this.state.value}
            onChange={this.handleChange}
            indicatorColor="primary"
            textColor="primary"
            centered
            fullWidth>
            <Tab label="All" />
            <Tab label="Categories" />
            <Tab label="Departments" />
          </Tabs>
        </AppBar>
        {value === 0 && <TabContainer> </TabContainer>}
        {value === 1 && <TabContainer>/group/?by=category</TabContainer>}
        {value === 2 && <TabContainer>/group/?by=department</TabContainer>}
      </div>
    );
  }
}

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(TableList);
