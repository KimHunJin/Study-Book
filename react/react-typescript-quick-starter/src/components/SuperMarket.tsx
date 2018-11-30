import * as React from 'react'
import SupermarketTemplate from './supermarket/SupermarketTemplate'
import ShopItemList from './shop/ShopItemList'
import BasketItemList from './basket/BasketItemList'
import TotalPrice from './utils/TotalPrice'

const SuperMarket : any = () => {
    return (
        <SupermarketTemplate
            items={<ShopItemList/>}
            basket={<BasketItemList/>}
            total={<TotalPrice/>}
        />
    )
}

export default SuperMarket