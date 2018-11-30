import {inject, observer} from 'mobx-react'
import React, { Component} from 'react'

@inject((stores: any) => ({
    number: stores.counter.number,
    increase: stores.counter.increase,
    decrease: stores.counter.decrease,
}))

@observer
class Counter extends Component {
    public render() {
        const { number, increase, decrease  } = this.props as any
        return (
            <div>
                <h1>{number}</h1>
                <button onClick={increase}>+1</button>
                <button onClick={decrease}>-1</button>
            </div>
        )
    }
}

export default Counter