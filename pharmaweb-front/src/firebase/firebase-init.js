import config from './firebase-config'
import firebase from 'firebase/app';
import 'firebase/auth';

if (!firebase.apps.length) {
  firebase.initializeApp(config);
}

const auth = firebase.auth();

export {
  auth
};
