import { messaging } from './firebase-init'

export const doRequestPermission = () =>
  messaging.requestPermission();

export const doReceiveMessage = () =>
  messaging.onMessage(function(payload) {
    console.log('Message received. ', payload);
  });

export const doGetToken = () =>
  messaging.getToken();
