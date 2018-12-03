import * as React from 'react';
import {Title} from "app/components/Title";
import {TabMenu} from "app/components/Tab";

export class Root extends React.Component<any, any> {
    renderDevTool() {
        if (process.env.NODE_ENV !== 'production') {
            const DevTools = require('mobx-react-devtools').default;
            return <DevTools/>;
        }
    }

    render() {
        return (
            <div className="container">
                <Title/>
                {TabMenu('todo')}
                {this.props.children}
                {this.renderDevTool()}
            </div>
        );
    }
}
