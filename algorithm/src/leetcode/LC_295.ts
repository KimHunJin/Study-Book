/**
 * 실패
 */

class MedianFinder {

    arr = [];

    constructor() {
        this.arr = [];
    }

    addNum(num: number): void {
        for (let i=0; i<this.arr.length; i++) {
            if (this.arr[i] >= num) {
                this.arr = [...this.arr.splice(0, i), num, ...this.arr];
                return;
            }
        }

        this.arr.push(num);
    }

    findMedian(): number {
        const length = this.arr.length;
        const half = Math.floor(length / 2);
        if (length % 2 === 0) {
            return (this.arr[half] + this.arr[half - 1]) / 2;
        } else {
            return this.arr[half];
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
