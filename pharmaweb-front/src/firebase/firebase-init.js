import config from './firebase-config'
import firebase from 'firebase/app';
import 'firebase/auth';
import 'firebase/messaging';

if (!firebase.apps.length) {
  firebase.initializeApp(config.firKey);
}

const auth = firebase.auth();
const messaging = firebase.messaging();
messaging.usePublicVapidKey(config.vapidKey);

navigator.serviceWorker.register(`${process.env.PUBLIC_URL}/firebase-messaging-sw.js`)
  .then((registration) => {
    messaging.useServiceWorker(registration);
  });

export {
  auth,
  messaging
};
