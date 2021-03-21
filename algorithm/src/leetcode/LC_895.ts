/**
 * Time Limit
 */
class FreqStack {

    stack: number[] = [];
    freqValue: number[] = [];

    constructor() {
        this.stack = [];
        this.freqValue = [];
    }

    push(val: number): void {
        this.stack.push(val);
        this.freqValue[val] = this.freqValue[val] === undefined ? 1 : this.freqValue[val] + 1;
    }

    pop(): number {
        let maxFreq = 0;
        let maxVal = 0;

        Object.keys(this.freqValue).forEach(key => {
            if (maxFreq <= this.freqValue[key]) {
                if (maxFreq === this.freqValue[key]) {
                    if (this.stack.lastIndexOf(maxVal) < this.stack.lastIndexOf(Number(key))) {
                        maxFreq = this.freqValue[key];
                        maxVal = Number(key);
                    }
                } else {
                    maxFreq = this.freqValue[key];
                    maxVal = Number(key);
                }
            }
        })

        const index = this.stack.lastIndexOf(maxVal);
        this.stack.splice(index, 1);
        this.freqValue[maxVal]--;
        return maxVal;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * var obj = new FreqStack()
 * obj.push(val)
 * var param_2 = obj.pop()
 */
