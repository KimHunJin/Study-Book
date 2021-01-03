function checkArithmeticSubarrays(nums: number[], l: number[], r: number[]): boolean[] {
    const size = l.length;

    const result: boolean[] = [];
    for (let i = 0; i < size; i++) {
        const array: number[] = makeArray(nums, l[i], r[i]);
        const diff: number = array[1] - array[0];
        const firstNumber: number = array[0];

        const invalidArithmetic = array.findIndex((it, index) => firstNumber + (index * diff) !== it);
        if (invalidArithmetic >= 0) {
            result[i] = false;
        } else {
            result[i] = true;
        }
    }

    return result;
};

function makeArray(nums: number[], l: number, r: number): number[] {
    return nums.filter((_, index) => index >= l && index <= r)
        .sort((a, b) => a - b);
}
