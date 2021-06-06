function runningSum(nums: number[]): number[] {
    let acc = 0;

    return nums.map(it => acc += it);
};
