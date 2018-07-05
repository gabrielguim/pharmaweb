import React from 'react';

const AuthUserContext = React.createContext({
  authUser: null,
  notifications: [],
  cart: [],
  userInfo: {
    'fullName': "Usuário",
    'email': "-",
    'uid': "",
    'registrationToken': "",
    'address': "",
    'phone': ""
  }
});

export default AuthUserContext;
