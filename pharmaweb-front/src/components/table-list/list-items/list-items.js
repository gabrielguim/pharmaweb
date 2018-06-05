import React from 'react';
import PropTypes from 'prop-types';

import listItemsStyle from './list-items-style'
import { firebase } from '../../../firebase/firebase';

import { withStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import ListSubheader from '@material-ui/core/ListSubheader';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';

import axios from 'axios';

class ListItems extends React.Component {

  state = {
      token: '',
      value: 0,
  };

  getProducts = (query) => {
    const uid = localStorage.getItem('I');
    const token = localStorage.getItem('F');

    console.log(headers);
    console.log(query);

    const headers = {
      headers: {
        'Content-Type': 'application/json',
        'token': token,
        'uid': uid
      }
    };

    axios.get('http://localhost:8081/api/products', headers)
      .then(res => {
        console.log(res);
      }).catch(error => {
        console.log(error);
      });
  };

  render() {
    const { classes } = this.props;

    console.log(this.props);

    this.getProducts(this.props.children);

    return (
      <div className={classes.root}>
        XISDE
      </div>
        // <GridList cellHeight={180} className={classes.gridList}>
        //   <GridListTile key="Subheader" cols={2} style={{ height: 'auto' }}>
        //     <ListSubheader component="div">December</ListSubheader>
        //   </GridListTile>
        //   {tileData.map(tile => (
        //     <GridListTile key={tile.img}>
        //       <img src={tile.img} alt={tile.title} />
        //       <GridListTileBar
        //         title={tile.title}
        //         subtitle={<span>by: {tile.author}</span>}
        //         actionIcon={
        //           <IconButton className={classes.icon}>
        //             <InfoIcon />
        //           </IconButton>
        //         }
        //       />
        //     </GridListTile>
        //   ))}
        // </GridList>

    );
  };

}

export default withStyles(listItemsStyle)(ListItems);
