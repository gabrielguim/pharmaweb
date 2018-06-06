import React from 'react';

import { withStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import Button from '@material-ui/core/Button';
import Hidden from '@material-ui/core/Hidden';
import Grid from '@material-ui/core/Grid';

import MenuIcon from '@material-ui/icons/Menu';

import homeStyle from '../home-style'
import { auth } from '../../../firebase/firebase';
import PDrawer from './drawer';

import axios from 'axios';

class PAppBar extends React.Component {

  state = {
    mobileOpen: false,
    fullName: 'Usuário',
    email: '-'
  };

  handleDrawerToggle = () => {
    this.setState({ mobileOpen: !this.state.mobileOpen });
  };

  logout = () => {
    localStorage.removeItem('I');
    localStorage.removeItem('F');
    localStorage.removeItem('M');
    localStorage.removeItem('U');

    auth.doSignOut()
  };

  componentDidMount = () => {
    this.getUserData();
  }

  getUserData = () => {
    const headers = {
      headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('F'),
        'uid': localStorage.getItem('I')
      }
    };

    axios.get('http://localhost:8081/api/users', headers)
      .then(res => {
        const fullName = res.data[0].fullName;
        const email = res.data[0].email;
        localStorage.setItem('U', fullName);
        localStorage.setItem('M', email);

        this.setState({ fullName: fullName, email: email });
      });
  }

  render() {
    const { classes, theme } = this.props;

    return (
      <div>
        <AppBar className={classes.appBar}>
          <Toolbar className={classes.appToolbar}>
            <Grid container alignItems="center" justify="space-between">
              <div>
                <IconButton
                  color="inherit"
                  aria-label="open drawer"
                  onClick={this.handleDrawerToggle}
                  className={classes.navIconHide}>
                  <MenuIcon />
                </IconButton>
                <div>
                  <Typography variant="title" color="inherit" noWrap >
                    Olá, { this.state.fullName }!
                  </Typography>
                  <Typography variant="subheading" color="inherit" noWrap>
                    como: { this.state.email }
                  </Typography>
                </div>
              </div>
              <Button color="inherit" onClick={() => this.logout() }>
                Logout
              </Button>
            </Grid>
          </Toolbar>
        </AppBar>
        <Hidden mdUp>
          <Drawer
            variant="temporary"
            anchor={theme.direction === 'rtl' ? 'right' : 'left'}
            open={this.state.mobileOpen}
            onClose={this.handleDrawerToggle}
            classes={{
              paper: classes.drawerPaper,
            }}
            ModalProps={{
              keepMounted: false, // Better open performance on mobile.
            }}>
            <PDrawer state={this.state} classes={classes} />
          </Drawer>
        </Hidden>
        <Hidden smDown implementation="css">
          <PDrawer state={this.state} classes={classes} />
        </Hidden>
      </div>
    );
  }

}

export default withStyles(homeStyle, { withTheme: true })(PAppBar);
