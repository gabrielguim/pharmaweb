import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './components/app/app';
import registerServiceWorker from './registerServiceWorker';
import 'typeface-roboto';
import { messaging } from './firebase/firebase'

ReactDOM.render(<App />, document.getElementById('root'));
messaging.doReceiveMessage()
registerServiceWorker();
