import React from 'react';

import cartItemStyle from './cart-style'
import { withStyles } from '@material-ui/core/styles';

import AuthUserContext from '../../session/auth-user-context';

import Button from '@material-ui/core/Button';

import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Avatar from '@material-ui/core/Avatar';

import axios from 'axios';

function Cart (props)  { 
  const { classes } = props;

  const sendOrder = (context) => {
    const uid = localStorage.getItem('I');
    const token = localStorage.getItem('F');
    const user = context.userInfo;
    const products = context.cart;
        
    const order = {
      'customer': user,
      'date': "22/06/2018",
      'status': "PENDENTE",
      'products': products
    };    
  
    const headers = {
      headers: {
        'Content-Type': 'application/json',
        'token': token,
        'uid': uid
      }
    };
  
    axios.post('http://localhost:8081/api/orders', order, headers)
      .then(response => {
        context.clearCart();
      })
      .catch(error => {          
        console.log(error);
      });
  }

  return (
    <AuthUserContext.Consumer>
      {(context) => {
        return (
          <div className={classes.root}>
            <List>
              {context.cart.map(product => {
                return(
                  <ListItem key={product.code}>
                    <Avatar alt={product.name} src={product.imageUrl} />
                    <ListItemText primary={product.name} secondary={product.price} />
                  </ListItem>
                )
              })}
              
              <ListItem>
                <Button variant="contained" color="primary" disabled={!context.cart.length} className={classes.button} onClick={() => sendOrder(context) }>
                  Send Order
                </Button>
              </ListItem>
              <ListItem>
                <Button variant="contained" color="secondary" className={classes.button} onClick={() => context.clearCart() }>
                  Clear Cart
                </Button>
              </ListItem>
            </List>
          </div>  
        )
      }}
    </AuthUserContext.Consumer>
  );
}

export default withStyles(cartItemStyle)(Cart);