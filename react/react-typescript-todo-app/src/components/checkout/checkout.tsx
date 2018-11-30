import * as React from 'react'
import * as Link from 'react-router'

export class Checkout extends React.Component{

    props:any

    render():React.ReactNode {
        let count = 0
        return(
            <div>
                <h1>Invoice</h1>
                <table className={"table table-bordered"}><tbody>
                {Object.keys(this.props.route.cartItems).map((item, index, list) => {
                    count+=this.props.route.cartItems[item]
                    return <tr key={item}>
                        <td>{this.props.route.product[item].title}</td>
                        <td>{this.props.route.cartItems[item]}mos</td>
                    </tr>
                })}
                </tbody></table><p>Total: {count}</p>
            </div>
        )
    }
}