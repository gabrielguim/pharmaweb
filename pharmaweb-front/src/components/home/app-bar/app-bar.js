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

import AuthUserContext from '../../../session/auth-user-context';

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

    auth.doSignOut();
  };

  render() {
    const { classes, theme } = this.props;

    return (
      <AuthUserContext.Consumer>
        {(context) => {          
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
                          Olá, { context.userInfo.fullName }!
                        </Typography>
                        <Typography variant="subheading" color="inherit" noWrap>
                          como: { context.userInfo.email }
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
                  <PDrawer state={this.state} classes={classes} context={context}/>
                </Drawer>
              </Hidden>
              <Hidden smDown implementation="css">
                <PDrawer state={this.state} classes={classes} context={context} />
              </Hidden>
            </div>
          );
        }
      }
      </AuthUserContext.Consumer>
    );
  }

}

export default withStyles(homeStyle, { withTheme: true })(PAppBar);
