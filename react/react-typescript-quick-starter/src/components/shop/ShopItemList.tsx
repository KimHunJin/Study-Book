import {inject, observer} from 'mobx-react'
import React from 'react'
import ShopItem from './ShopItem'

const items = [
    {
        name: '생수',
        price: 850,
    },
    {
        name: '신라면',
        price: 900,
    },
    {
        name: '포카칩',
        price: 1500,
    },
    {
        name: '새우깡',
        price: 1000,
    },
]

const ShopItemList = ({ onPut } : {onPut: any}) => {
    const itemList = items.map(item => (
        <ShopItem {...item} key={item.name} onPut={onPut} />
    ))
    return <div>{itemList}</div>
}

export default inject(({market}) => ({
    onPut: market.put as any,
}))(observer(ShopItemList)) as any