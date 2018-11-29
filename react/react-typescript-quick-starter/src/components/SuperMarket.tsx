import * as React from 'react'
import SupermarketTemplate from './SupermarketTemplate'
import ShopItemList from './ShopItemList'
import BasketItemList from './BasketItemList'
import TotalPrice from './TotalPrice'

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