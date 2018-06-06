import React from 'react';

import listItemsStyle from './list-items-style'

import { withStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';

import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';

function ListDefault(parentProps) {
  const { list } = parentProps
  const classes = parentProps.classes

  return (
    <GridList cols={8} spacing={32} className={classes.gridList}>
      {list.map(item => (
        <GridListTile key={item.code}>
          <img src={item.imageUrl} alt={item.name} />
          <GridListTileBar
            title={item.name}
            subtitle={<span>R$ {item.price}</span>}
            actionIcon={
              <IconButton className={classes.icon}>
                <InfoIcon />
              </IconButton>
            }/>
        </GridListTile>
      ))}
    </GridList>
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
      ? <ListWithHeader { ... parentProps } />
      : <ListDefault { ... parentProps } />
  );
}

export default withStyles(listItemsStyle)(CustomList);
