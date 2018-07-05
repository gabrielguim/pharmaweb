import { messaging } from './firebase-init'

export const doRequestPermission = () =>
  messaging.requestPermission();

export const doReceiveMessage = (context) =>
  messaging.onMessage(function(payload) {
    context.updateNotifications(payload);   
    console.log('Message received. ', payload);
  });

export const doGetToken = () =>
  messaging.getToken();
