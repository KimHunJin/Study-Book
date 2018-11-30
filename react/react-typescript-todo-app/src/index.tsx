import * as React from 'react'
import * as ReactDOM from 'react-dom'
import "./styles/style.scss";
import {Provider} from "mobx-react";
import {Router, Route, IndexRoute} from 'react-router'
import {App} from "./App";
import {Index} from "./components/link/link";
import {Product} from "./components/product/product";
import {PRODUCTS} from "./model/products";
import {Cart} from "./components/cart/cart";
import {Checkout} from "./components/checkout/checkout";

let cartItems = {}
const addToCart = (id) => {
    if (cartItems[id])
        cartItems[id] += 1
    else
        cartItems[id] = 1
}


ReactDOM.render(
    <Provider>
        <Router>
            <Route path={"/"} component={App}>
                <IndexRoute component={Index}/>
                <Route path={"/product/:id"} component={Product}
                       addToCart={addToCart}
                       products={PRODUCTS}/>
                <Route path={"/cart"} component={Cart}
                       cartItems={cartItems} products={PRODUCTS}/>
            </Route>
            <Route path={"/checkout"} component={Checkout}
                   cartitems={cartItems} products={PRODUCTS}/>
        </Router>
    </Provider>,
    document.getElementById('root') as HTMLElement
)
