import { observable, action, computed} from "mobx";
import RootStore from "./index";
import {SelectedItem} from "./SelectedItem";

export default class MarketStore {

    @observable selectedItems : SelectedItem[] = []

    root : RootStore

    constructor(root : RootStore) {
        this.root = root
    }

    @action
    put: Function = (name : string, price : number) : void => {
        const {number} = this.root.counter

        const exists : any = this.selectedItems.find((item: SelectedItem) => item.name === name)
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
    take = (name: string) : void => {
        const itemToTake: any = this.selectedItems.find((item: SelectedItem) => item.name === name) as SelectedItem
        itemToTake.count--
        if(itemToTake.count === 0) {
            this.selectedItems.splice(this.selectedItems.indexOf(itemToTake), 1)
        }
    }

    @computed
    get total() : number {
        console.log('총합 계산...')
        return this.selectedItems.reduce((previous: any, current: any) => {
            return previous + current.price * current.count
        }, 0)
    }
}