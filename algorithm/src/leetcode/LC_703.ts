class KthLargest {

    k: number;
    nums: number[];

    constructor(k: number, nums: number[]) {
        this.k = k;
        this.nums = nums;
    }

    add(val: number): number {
        this.nums.push(val);
        return this.nums.sort((a,b) => b-a)[this.k-1];
    }
}
