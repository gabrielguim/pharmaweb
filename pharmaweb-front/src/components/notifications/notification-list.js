import React from 'react';

import notificationItemStyle from './notification-style'
import { withStyles } from '@material-ui/core/styles';

import AuthUserContext from '../../session/auth-user-context';

import Button from '@material-ui/core/Button';

import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import Typography from '@material-ui/core/Typography';

import ListItemText from '@material-ui/core/ListItemText';
import Avatar from '@material-ui/core/Avatar';

import Delete from '@material-ui/icons/Delete';

import axios from 'axios';

function NotificationList (props)  { 
  const { classes } = props;

  const viewNotification = (notification) => {
    console.log(notification);
  }

  return (
    <AuthUserContext.Consumer>
      {(context) => {          
       return (
        <div className={classes.root}>
          <List>
            {context.notifications.map(notification => {
              return(
                <ListItem key={notification.code} onClick={() => viewNotification(notification) }>
                  <Typography className={classes.view_notification}>
                    {
                      ! notification.viewed
                      ? "•"
                      : ""
                    }
                  </Typography>
                  <ListItemText primary={notification.message} secondary={notification.from} />
                </ListItem>
              )
            })}
          </List>
        </div>
       )
      }}
    </AuthUserContext.Consumer>
  );
}

export default withStyles(notificationItemStyle)(NotificationList);