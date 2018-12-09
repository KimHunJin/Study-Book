import * as React from 'react';
import {hot} from 'react-hot-loader';
import {Route, Router, Switch} from 'react-router';
import {Root} from 'app/containers/Root';
import {TodoApp} from 'app/containers/TodoApp';
import {TabMenu} from "app/components/Tab";
import {Diary} from "app/containers/DiaryApp";

// render react DOM
export const App = hot(module)(({history}) => (
    <Root>
        <Router history={history}>
            <Switch>
                <Route path="/todo" component={TodoApp}/>
                <Route path="/diary" component={Diary} />
                <Route path="/" component={TabMenu} />
            </Switch>
        </Router>
    </Root>
));
