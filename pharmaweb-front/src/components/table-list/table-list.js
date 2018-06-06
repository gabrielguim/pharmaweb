import React from "react";
import withAuthorization from '../../session/withAuthorization';

import listItemsStyle from './list-items/list-items-style'
import { withStyles } from '@material-ui/core/styles';

import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';

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
    const { classes } = this.props;
    const { value } = this.state;

    return (
      <div>
        <AppBar className={classes.appBar} color="default">
          <Tabs
            value={this.state.value}
            onChange={this.handleChange}
            classes={{ root: classes.tabsRoot, indicator: classes.tabsIndicator }}
            centered
            fullWidth>
            <Tab label="All" classes={{ root: classes.tabRoot, selected: classes.tabSelected }} />
            <Tab label="Categories" classes={{ root: classes.tabRoot, selected: classes.tabSelected }} />
            <Tab label="Departments" classes={{ root: classes.tabRoot, selected: classes.tabSelected }} />
          </Tabs>
        </AppBar>
        {value === 0 && <TabContainer></TabContainer>}
        {value === 1 && <TabContainer>/group/?by=category</TabContainer>}
        {value === 2 && <TabContainer>/group/?by=department</TabContainer>}
      </div>
    );
  }
}

const authCondition = (authUser) => !!authUser;

export default withAuthorization(authCondition)(withStyles(listItemsStyle)(TableList));
