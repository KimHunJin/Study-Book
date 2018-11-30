import * as React from 'react'
import * as Link from 'react-router'

export class Modal extends React.Component {

    style: any
    props: any

    constructor(props) {
        super(props)
        this.style = {
            position: 'fixed',
            top: '20%',
            right: '20%',
            bottom: '20%',
            background: '#fff',
            padding: 20,
            width: 450,
            height: 400
        }
    }

    render(): React.ReactNode {
        return (
            <div style={this.style}>
                <p><Link to={this.props.returnTo}>back</Link></p>
                {this.props.children}
            </div>
        )
    }
}