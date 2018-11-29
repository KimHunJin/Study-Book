import { observable, action, computed} from "mobx";

export default class MarketStore {
    @observable selectedItems = [] as any

    root : any

    constructor(root : any) {
        this.root = root
    }

    @action
    put = (name : any, price : any) => {
        const { number } = this.root.counter

        const exists = this.selectedItems.find((item: any) => item.name === name)
        if(!exists) {
            this.selectedItems.push({
                name,
                price,
                count: number
            })
            return
        }
        exists.count += number
    }

    @action
    take = (name: any) => {
        const itemToTake = this.selectedItems.find((item: any) => item.name === name)
        itemToTake.count--
        if(itemToTake.count === 0) {
            this.selectedItems.remove(itemToTake)
        }
    }

    @computed
    get total() {
        console.log('총합 계산...')
        return this.selectedItems.reduce((previous: any, current: any) => {
            return previous + current.price * current.count
        }, 0)
    }
}