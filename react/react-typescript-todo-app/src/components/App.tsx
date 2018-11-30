import * as React from "react"

export class App extends React.Component<any, any> {
    public render() {
        return <h3>Hello, {this.props.name}</h3>
    }
}