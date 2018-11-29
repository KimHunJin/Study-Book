import * as React from 'react';
import * as ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import {Provider} from "mobx-react";
import registerServiceWorker from './registerServiceWorker';
import RootStore from "./stores";

const root = new RootStore()

ReactDOM.render(
    <Provider {...root}>
        <App />
    </Provider>,
    document.getElementById('root') as HTMLElement
);
registerServiceWorker();
