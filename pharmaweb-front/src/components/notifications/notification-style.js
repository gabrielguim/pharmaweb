const notificationItemStyle = theme => ({
    root: {
      display: 'flex',
      flexWrap: 'wrap',
      justifyContent: 'center',
      overflow: 'hidden',
      height: '100%',
      width: '100%',
      backgroundColor: theme.palette.background.paper,
      marginTop: 32
    },

    view_notification: {
      fontSize: 32,
      color: '#E86706'
    }
});

export default notificationItemStyle;
