import {action, observable} from "mobx";

export default class CounterStore {
    @observable public number = 1 as any
    root: any

    constructor(root : any) {
        this.root = root as any
    }

    @action
    public increase = () => {
        this.number ++
    }
    
    @action
    public decrease = () => {
        this.number --
    }
}