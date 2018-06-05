import React from 'react';
import classNames from 'classnames';

import { withStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import Button from '@material-ui/core/Button';
import ListSubheader from '@material-ui/core/ListSubheader';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';

import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';

import homeStyle from '../home-style'
import { NavLink } from 'react-router-dom';

import routes from '../../../router/navigation-routes'

import { auth } from '../../../firebase/firebase';

class CDrawer extends React.Component {

  state = {
    open: false,
    barName: "PharmaWeb"
  };

  handleDrawer = () => {
    this.setState({ open: !this.state.open });
  };

  logout = () => {
    localStorage.removeItem('I');
    localStorage.removeItem('F');

    auth.doSignOut()
  };

  render() {
    const { classes, theme } = this.props;

    return (
      <div>
        <AppBar
          position="absolute"
          className={classNames(classes.appBar, this.state.open && classes.appBarShift)}>
          <Toolbar disableGutters={!this.state.open}>
            <IconButton
              color="inherit"
              aria-label="open drawer"
              onClick={this.handleDrawer}
              className={classNames(classes.leftMenuButton, this.state.open && classes.hide)}>
              <MenuIcon />
            </IconButton>
            <Typography variant="title" color="inherit" className={classes.flex}>
              { this.state.barName }
            </Typography>
            <Button color="inherit" onClick={() => this.logout() }>
              Logout
            </Button>
          </Toolbar>
        </AppBar>
        <Drawer
          variant="permanent"
          classes={{
            paper: classNames(classes.drawerPaper, !this.state.open && classes.drawerPaperClose),
          }}
          open={this.state.open}>
          <div className={classes.toolbar}>
            <IconButton onClick={this.handleDrawer}>
              {theme.direction === 'rtl' ? <ChevronRightIcon /> : <ChevronLeftIcon />}
            </IconButton>
          </div>
          <Divider />
          <Divider />
            <ListSubheader hidden={!this.state.open}>Menu</ListSubheader>
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
      </div>
    );
  }

}

export default withStyles(homeStyle, { withTheme: true })(CDrawer);
