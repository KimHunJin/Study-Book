import React from 'react'
import './SuperMarketTemplate.css'

const SuperMarketTemplate = ({items, basket, total} : { items: any, basket: any, total: any }) => {
    return (
        <div className="SuperMarketTemplate">
            <div className="items-wrapper">
                <h2>상품</h2>
                {items}
            </div>
            <div className="basket-wrapper">
                <h2>장바구니</h2>
                {basket}
                {total}
            </div>
        </div>
    )
}

export default SuperMarketTemplate