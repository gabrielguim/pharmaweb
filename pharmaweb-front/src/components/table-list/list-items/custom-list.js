import React from 'react';

import listItemsStyle from './list-items-style'

import { withStyles } from '@material-ui/core/styles';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Paper';

import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import CardMedia from '@material-ui/core/CardMedia';
import Grid from '@material-ui/core/Grid';

import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import AddShoppingCart from '@material-ui/icons/AddShoppingCart';

import AuthUserContext from '../../../session/auth-user-context';
import axios from 'axios';

function ListDefault(parentProps) {
  const { list } = parentProps
  const classes = parentProps.classes

  return (
    <AuthUserContext.Consumer>
      {(context) => {
        return (
          <Grid container className={classes.gridList} spacing={32}>
            {list.map(product => (
              <Grid item key={product.code} xs={12} md={6} lg={3} xl={2} >
                <Card>
                  <CardMedia
                    className={classes.media}
                    title={product.name}
                    image={product.imageUrl}
                  />
                  <CardContent>
                    <Typography gutterBottom variant="headline" component="h2">
                      {product.name}
                    </Typography>
                    <Typography component="p">
                      {product.description}
                    </Typography>
                  </CardContent>
                  <CardActions className={classes.actions}>
                    <Paper className={classes.rightItem} elevation={1}>
                      <Typography className={classes.priceText} variant="headline" component="h3">
                        R$ { product.price }
                      </Typography>
                    </Paper>
                  </CardActions>
                  <CardActions className={classes.actions}>
                    <Paper className={classes.cartItem} elevation={1} onClick={() => context.addToCart(product) }>
                      <Typography className={classes.priceText} variant="headline" component="h3">
                        <AddShoppingCart />
                      </Typography>
                    </Paper>
                  </CardActions>
                </Card>
              </Grid>
            ))}
          </Grid>
        )
      }
    }
    </AuthUserContext.Consumer>
  );
}

function ListWithHeader(parentProps) {
  const { list, ...props } = parentProps
  const classes = parentProps.classes
  const keys = Object.keys(list);

  return (
    <div className={classes.rootExp}>
      {keys.map(key => (
        <ExpansionPanel key={key}>
          <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />}>
            <Typography className={classes.heading}>{key}</Typography>
          </ExpansionPanelSummary>
          <ExpansionPanelDetails>
            <ListDefault list={list[key]} { ...props } />
          </ExpansionPanelDetails>
        </ExpansionPanel>
      ))}
    </div>
  );

}

function CustomList(parentProps) {
  const query = parentProps.children

  return (
    query
      ? <ListWithHeader { ...parentProps } />
      : <ListDefault { ...parentProps } />
  );
}

export default withStyles(listItemsStyle)(CustomList);
