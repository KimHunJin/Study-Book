import * as React from 'react';
import * as css from './style.css'
import {Title} from "app/components/Title";

export class Root extends React.Component<any, any> {
    renderDevTool() {
        if (process.env.NODE_ENV !== 'production') {
            const DevTools = require('mobx-react-devtools').default;
            return <DevTools/>;
        }
    }

    render() {
        return (
            <div className={css.container}>
                <div className={css.normal}>
                    <Title/>
                    {this.props.children}
                    {this.renderDevTool()}
                </div>
            </div>
        );
    }
}
