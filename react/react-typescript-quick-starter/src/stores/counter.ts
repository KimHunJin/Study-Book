import {action, observable} from "mobx";
import RootStore from "./index";

export default class CounterStore {
    @observable public number : number = 1
    root: RootStore

    constructor(root : RootStore) {
        this.root = root
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