import * as React from "react"
import * as ReactDOM from "react-dom"
import {Modal} from "./components/modal/modal";


export class App extends React.Component<any, any> {

    isModal: any
    previousChildren: any

    componentWillReceiveProps(nextProps: Readonly<any>, nextContext: any): void {
        this.isModal = (nextProps.location.state && nextProps.location.state.modal)
        if (this.isModal && nextProps.location.key !== this.props.location.key) {
            this.previousChildren = this.props.children
        }
    }

    public render() {
        return (
            <div className={"well"}>
                <div>
                    {(this.isModal) ? this.previousChildren : this.props.children}
                    {(this.isModal) ?
                        <Modal isOpen={true} returnTo={this.props.location.state.returnTo}>
                            {this.props.children}
                        </Modal> : ''
                    }
                </div>
            </div>
        )
    }
}