import {inject, observer} from 'mobx-react'
import React, {Component} from 'react'

@inject(({market}) => ({total: market.total}))
@observer
class TotalPrice extends Component {
    public render() {
        // @ts-ignore
        const { total } = this.props
        return (
            <div>
                <hr />
                <p>
                    <b>총합: </b> {total}원
                </p>
            </div>
        )
    }
}

export default TotalPrice