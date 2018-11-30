import {inject, observer} from 'mobx-react'
import * as React from 'react'
import BasketItem from './Basketitem'
import {SelectedItem} from "../../stores/SelectedItem";

const BasketItemList = ({items, total, onTake}: { items: SelectedItem[], total: number, onTake: Function }) => {
    const itemList = items.map((item : SelectedItem): any => (
        <BasketItem item={item} key={item.name} onTake={onTake}/>
    ))
    return <div>{itemList}</div>
}

export default inject(({market}) => ({
    items: market.selectedItems,
    onTake: market.take,
}))(observer(BasketItemList)) as any