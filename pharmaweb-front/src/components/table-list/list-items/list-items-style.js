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
  media: {
    height: 0,
    paddingTop: '56.25%', // 16:9
  },
  actions: {
    display: 'flex',
  },
  cartItem: {
    marginLeft: 'auto',
    paddingTop: 10,
    paddingBottom: 0,
    paddingLeft: 30,
    paddingRight: 30,
    backgroundColor: "#8F1337"
  },
  rightItem: {
    marginLeft: 'auto',
    paddingTop: 5,
    paddingBottom: 5,
    paddingLeft: 30,
    paddingRight: 30,
    backgroundColor: "#EA6706"
  },
  priceText: {
    color: 'white',
  },
  listRoot: {
    width: '100%',
    backgroundColor: theme.palette.background.paper,
  },
  appBar: {
    position: "fixed",
    top: 80,
    marginLeft: 240,
    [theme.breakpoints.up('md')]: {
      width: `calc(100% - ${240}px)`,
    },
  },
  loadingProgress: {
    marginTop: 80
  },
  rootExp: {
    width: '100%',
    height: '100%',
    marginTop: 12,
    marginBottom: 12,
    marginLeft: 32,
    marginRight: 32
  },
  gridList: {
    margin: 8
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight: theme.typography.fontWeightRegular,
  },
  tabsRoot: {
    borderBottom: '1px solid #E57827',
  },
  tabsIndicator: {
    backgroundColor: '#E57827',
  },
  tabRoot: {
    '&:hover': {
      color: '#E57827',
      opacity: 1,
    },
    '&$tabSelected': {
      color: '#E57827',
    },
    '&:focus': {
      color: '#E57827',
    }
  },
  tabSelected: {},
  icon: {
    color: '#E57827',
  },
});

export default listItemsStyle;
