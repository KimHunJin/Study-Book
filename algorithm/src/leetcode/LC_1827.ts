function minOperations(nums: number[]): number {
    let before = -1;
    let sum = 0;

    nums.forEach(num => {
        if (before >= num) {
            before = before + 1;
            sum += before - num;
        } else {
            before = num;
        }
    });

    return sum;
};