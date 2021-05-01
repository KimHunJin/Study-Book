class MyCircularQueue {

    size = 0;
    cSize = 0;
    queue = [];
    index = 0;

    constructor(k: number) {
        this.size = k;
    }

    enQueue(value: number): boolean {
        if (this.cSize >= this.size) {
            return false;
        }

        this.cSize++;
        this.queue.push(value);
        return true;
    }

    deQueue(): boolean {
        if (this.cSize <= 0) {
            return false;
        }
        this.index++;
        this.cSize--;
        return true;
    }

    Front(): number {
        return this.queue?.[this.index] ?? -1;
    }

    Rear(): number {
        if (this.isEmpty()) {
            return -1;
        }
        return this.queue?.[this.queue.length-1] ?? -1;
    }

    isEmpty(): boolean {
        return this.cSize <= 0;
    }

    isFull(): boolean {
        return this.cSize >= this.size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = new MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
