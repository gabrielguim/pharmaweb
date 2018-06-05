const signInStyle = theme => ({
  card: {
    borderRadius: 12,
  },
  root: theme.mixins.gutters({
    paddingTop: 16,
    paddingBottom: 16,
  }),
  error: {
    backgroundColor: '#FD5757',
  },
  error_text: {
    color: 'white'
  },
  marginPass: {
    width: `calc(100% - 18px)`,
    margin: theme.spacing.unit,
    marginTop: 32
  },
  navLink: {
    color: '#E10050',
    textDecoration: 'none'
  },
  margin: {
    margin: theme.spacing.unit,
    marginTop: 32
  },
  sign_in: {
    marginLeft: 'auto',
  },
  title: {
    marginBottom: 16,
    fontSize: 14,
  },
  pos: {
    marginBottom: 12,
  },
});

export default signInStyle;
