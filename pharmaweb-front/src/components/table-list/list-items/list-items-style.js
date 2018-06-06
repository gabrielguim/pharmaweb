const listItemsStyle = theme => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
    overflow: 'hidden',
    height: '100%',
    backgroundColor: theme.palette.background.paper,
    marginTop: 32
  },
  loadingProgress: {
    marginTop: 16
  },
  rootExp: {
    width: '100%',
    height: '100%',
    marginTop: 12,
    marginBottom: 12,
    marginLeft: 32,
    marginRight: 32
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight: theme.typography.fontWeightRegular,
  },
  gridList: {
    width: '100%',
    height: '100%'
  },
  icon: {
    color: 'rgba(255, 255, 255, 0.54)',
  },
});

export default listItemsStyle;
