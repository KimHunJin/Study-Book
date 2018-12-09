export class DiaryModel {
    readonly id: number

    constructor() {

    }

    static nextId = 1

    static generateId() : number {
        return this.nextId++
    }
}