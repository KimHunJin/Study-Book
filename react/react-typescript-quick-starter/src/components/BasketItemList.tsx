import {inject, observer} from 'mobx-react'
import * as React from 'react'
import BasketItem from './Basketitem'

const BasketItemList = ({items, total, onTake}: {items: any, total:any, onTake: any}) => {
    const itemList = items.map( (item:any) : any => (
        <BasketItem item={item} key={item.name} onTake={onTake} />
    ))
return <div>{itemList}</div> as any
}

export default inject(({market}) => ({
    items: market.selectedItems,
    onTake: market.take,
}))(observer(BasketItemList))