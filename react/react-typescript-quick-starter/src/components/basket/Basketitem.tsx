import { observer } from 'mobx-react'
import * as React from 'react'
import './BasketItem.css'

const BasketItem = observer(({item, onTake}) => {
    return (
        <div className="BasketItem">
            <div className="name">{item.name}</div>
            <div className="price">{item.price}원</div>
            <div className="count">{item.count}</div>
            <div className="return" onClick={() => onTake(item.name)}>
                갖다놓기
            </div>
        </div>
    )
})

export default BasketItem