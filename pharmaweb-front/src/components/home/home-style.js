const drawerWidth = 240;

const homeStyle = theme => ({
  flex: {
    flex: 1,
  },
  menuButton: {
    marginLeft: -12,
    marginRight: 20,
  },
  pharmaLogo: {
    marginTop: 18,
    marginBottom: 18
  },
  pharmaAvatar: {
    color: 'white',
    margin: 10,
    backgroundColor: "#8F1337",
  },
  loginNavLink: {
    color: 'white',
    textDecoration: 'none'
  },
  navLink: {
    color: '#757575',
    textDecoration: 'none'
  },
  activeLink: {
    color: 'black',
    backgroundColor: '#EBEBEB'
  },
  root: {
    flexGrow: 1,
    zIndex: 1,
    overflow: 'hidden',
    position: 'relative',
    display: 'flex',
    width: '100%',
  },
  appToolbar : {
    height: 80,
  },
  appBar: {
    position: "fixed",
    top: 0,
    height: 80,
    backgroundColor: "#E86706",
    marginLeft: drawerWidth,
    [theme.breakpoints.up('md')]: {
      width: `calc(100% - ${drawerWidth}px)`,
    },
  },
  navIconHide: {
    [theme.breakpoints.up('md')]: {
      display: 'none',
    },
  },
  toolbar: theme.mixins.toolbar,
  drawerPaper: {
    width: drawerWidth,
    [theme.breakpoints.up('md')]: {
      position: 'relative',
    },
  },
  content: {
    flexGrow: 1,
    backgroundColor: 'white',
    padding: theme.spacing.unit * 3,
  },
});

export default homeStyle;
