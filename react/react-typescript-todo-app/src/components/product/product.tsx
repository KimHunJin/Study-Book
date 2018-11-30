import * as React from 'react'
import * as Link from 'react-router'

export class Product extends React.Component {

    props: any

    handleBuy(event) {
        this.props.route.addToCart(this.props.params.id)
    }

    constructor(props) {
        super(props)
        this.handleBuy = this.handleBuy.bind(this)
    }

    render() : React.ReactNode {
        return (
            <div>
                <img src={this.props.route.products[this.props.params.id].src} style={{height: '80%'}}/>
                <p>{this.props.route.product[this.props.params.id].title}</p>
                <Link
                    to={{
                        pathname: `/cart`,
                        state: {productId: this.props.params.id}
                    }}
                    onClick={this.handleBuy}
                    className={"btn btn-primary"}>
                    Buy
                </Link>
            </div>
        )
    }
}