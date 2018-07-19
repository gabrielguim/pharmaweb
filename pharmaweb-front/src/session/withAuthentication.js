import React from 'react';

import AuthUserContext from './auth-user-context';
import { firebase } from '../firebase/firebase';

import axios from 'axios';

const withAuthentication = (Component) =>
  class WithAuthentication extends React.Component {
    constructor(props) {
      super(props);

      this.state = {
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
        },
        changeUserInfo: (userInfo) => {          
          this.setState(() => ({ userInfo: userInfo }))
        },
        addToCart: (product) => {
          this.setState(() => ({ cart: [...this.state.cart, product]}))
        },
        clearCart: () => {
          this.setState(() => ({ cart: [] }))
        },
        updateNotifications: (notification) => {
          this.setState(() => (
            this.state.notifications.includes(notification)
              ? { notifications: [...this.state.notifications] }
              : { notifications: [...this.state.notifications, notification] }
          ))
        }
      };
    }

    changeState(authUser, userInfo) {
      this.setState(() => ({ authUser: authUser, userInfo: userInfo }))
    }

    componentDidMount() {
      const self = this;
      firebase.auth.onAuthStateChanged(authUser => { 
        if (authUser) {          
          authUser.getIdToken().then(function(data) {
            const uid = authUser.uid;
            const token = data;
            const headers = {
              headers: {
                'Content-Type': 'application/json',
                'token': token,
                'uid': uid
              }
            };

            localStorage.setItem('I', uid);
            localStorage.setItem('F', token);

            axios.get('http://localhost:8081/api/customers/' + uid, headers)
              .then(response => {
                const user = response.data

                localStorage.setItem('M', user.email);
                localStorage.setItem('U', user.fullName);                

                self.changeState(authUser, user);
              })
          });
        }

        authUser
          ? this.setState(() => ({ authUser: authUser }))
          : this.setState(() => ({ authUser: null }));          
      });
    }

    render() {
      return (
        <AuthUserContext.Provider value={this.state}>
          <Component />
        </AuthUserContext.Provider>
      );
    }
  }

export default withAuthentication;
