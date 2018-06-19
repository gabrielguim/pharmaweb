import React from 'react';
import classNames from 'classnames';

import { withStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';
import IconButton from '@material-ui/core/IconButton';
import Input from '@material-ui/core/Input';
import InputLabel from '@material-ui/core/InputLabel';
import InputAdornment from '@material-ui/core/InputAdornment';
import TextField from '@material-ui/core/TextField';
import FormControl from '@material-ui/core/FormControl';
import LinearProgress from '@material-ui/core/LinearProgress';
import Fade from '@material-ui/core/Fade';
import Paper from '@material-ui/core/Paper';

import { NavLink } from 'react-router-dom';

import Visibility from '@material-ui/icons/Visibility';
import VisibilityOff from '@material-ui/icons/VisibilityOff';

import { auth } from '../../firebase/firebase';

import signInStyle from './sign-in-style'

class SignIn extends React.Component {

  state = {
    password: '',
    email: '',
    showPassword: false,
    error: null,
    loading: false
  };

  async getAsyncToken(user) {
    console.log(user);
    auth.doCheckToken().then(function(data) {
      const uid = user.uid;
      const token = data;

      localStorage.setItem('I', uid);
      localStorage.setItem('F', token);
      
    });
  }

  authWithFirebase = () => {
    const {
      email,
      password,
    } = this.state;

    this.setState({ loading: true });
    auth.doSignInWithEmailAndPassword(email, password)
      .then((authUser) => {
        this.getAsyncToken(authUser.user);
      })
      .catch(error => {
        this.setState({
          error: error.message,
          loading: false
        });
      });

  };

  handleChange = prop => event => {
    this.setState({ [prop]: event.target.value });
  };

  handleMouseDownPassword = event => {
    event.preventDefault();
  };

  handleClickShowPassword = () => {
    this.setState({ showPassword: !this.state.showPassword });
  };

  linearProgress = () => {
    const { loading } = this.state;

    return (
      <div>
        <Fade
          in={loading}
          style={{
            transitionDelay: loading ? '200ms' : '200ms',
          }}
          unmountOnExit>
          <LinearProgress color="secondary" />
        </Fade>
      </div>
    );
  };

  loginForm = (classes) => {
    return (
      <div>
        <div className={classes.margin}>
          <TextField
            id="email"
            label="E-mail"
            value={this.state.email}
            onChange={this.handleChange('email')}
            margin="normal"
            fullWidth
          />
        </div>
        <FormControl fullWidth className={classes.marginPass}>
          <InputLabel htmlFor="adornment-password">Senha</InputLabel>
          <Input
            id="adornment-password"
            type={this.state.showPassword ? 'text' : 'password'}
            value={this.state.password}
            onChange={this.handleChange('password')}
            endAdornment={
              <InputAdornment position="end">
                <IconButton
                  aria-label="Toggle password visibility"
                  onClick={this.handleClickShowPassword}
                  onMouseDown={this.handleMouseDownPassword}>
                  {this.state.showPassword ? <VisibilityOff /> : <Visibility />}
                </IconButton>
              </InputAdornment>
            }
          />
        </FormControl>
      </div>
    );
  };

  render() {
    const { classes } = this.props;

    const {
      email,
      password,
      error,
    } = this.state;

    const isInvalid =
      password === '' ||
      email === '';

    return (
      <Grid
        container
        spacing={16}
        alignItems="center"
        direction="row"
        justify="center">
        <Grid item xl={2} lg={3} md={6} xs={12} >
          <div>
            <Card className={classes.card}>
              <CardContent>
                <Typography className={classes.title} color="textSecondary">
                  Entrar
                </Typography>
                { this.linearProgress() }
                { this.loginForm(classes) }
              </CardContent>
              <CardActions>
                <div className={classNames(classes.sign_in, classes.margin)}>
                  <Button color="secondary">
                    <NavLink exact to={'sign-up'} className={classes.navLink}>
                      REGISTRAR-SE
                    </NavLink>
                  </Button>
                  <Button color="primary" onClick={this.authWithFirebase} disabled={isInvalid}>ENTRAR</Button>
                </div>
              </CardActions>
              <Paper hidden={!error} className={classNames(classes.root, classes.error)} elevation={4}>
                <Typography component="p" className={classes.error_text}>
                  { error }
                </Typography>
              </Paper>
            </Card>
          </div>
        </Grid>
      </Grid>
    );
  }
}

export default withStyles(signInStyle)(SignIn);
