import React from 'react';
import classNames from 'classnames';

import { withStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import ListSubheader from '@material-ui/core/ListSubheader';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import Avatar from '@material-ui/core/Avatar';

import LocalPharmacy from '@material-ui/icons/LocalPharmacy';

import homeStyle from '../home-style'
import { NavLink } from 'react-router-dom';

import routes from '../../../router/navigation-routes'

const PDrawer = (props) => {
  const { state, classes } = props;

  return (
    <Drawer
      variant="permanent"
      classes={{
        paper: classNames(classes.drawerPaper, !state.open && classes.drawerPaperClose),
      }}
      open={state.open}>
      <ListItem className={classes.pharmaLogo}>
        <Avatar className={classes.pharmaAvatar}>
          <LocalPharmacy />
        </Avatar>
        <Typography variant="title" color="inherit">
          Pharmaweb
        </Typography>
      </ListItem>
      <Divider />
      <Divider />
        <ListSubheader hidden={!state.open}>Menu</ListSubheader>
          {routes.map((prop, key) => {
            return (
              <NavLink exact to={prop.path} key={key} className={classes.navLink} activeClassName={classes.activeLink}>
                <ListItem button>
                  <ListItemIcon>
                    <prop.icon />
                  </ListItemIcon>
                  <ListItemText
                    primary={prop.sidebarName}
                    disableTypography={true}
                  />
                </ListItem>
              </NavLink>
            );
          })}
    </Drawer>
  );
}

export default withStyles(homeStyle, { withTheme: true })(PDrawer);
