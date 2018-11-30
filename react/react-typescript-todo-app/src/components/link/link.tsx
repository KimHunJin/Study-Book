import * as React from "react";
import * as Link from 'react-router'
import {PRODUCTS} from "../../model/products";

const Copy = () => {
    return <p>Please click on a book to view details in a modal. You can copy/paste the link of the modal. The link will
        open the book on a separate page.</p>
}




export class Index extends React.Component {

    props: any

    render(): React.ReactNode {
        return (
            <div>
                <Copy/>
                <p><Link to={'/cart'} className={"btn btn-danger"}>Cart</Link></p>
                <div>
                    {PRODUCTS.map(picture => (
                        <Link key={picture.id}
                              to={{
                                  pathname: `/products/${picture.id}`,
                                  state: {
                                      modal: true,
                                      returnTo: this.props.location.pathname
                                  }
                              }}>
                            <img style={{margin:10}} src={picture.src} height={"100"} />
                        </Link>
                    ))}
                </div>
            </div>
        )
    }
}