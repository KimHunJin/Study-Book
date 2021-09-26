class MyHashSet {
    map = {};

    constructor() {
        this.map = {};
    }

    add(key: number): void {
        this.map[key] = key;
    }

    remove(key: number): void {
        this.map[key] = null;
    }

    contains(key: number): boolean {
        return this.map[key] !== null && this.map[key] !== undefined;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
