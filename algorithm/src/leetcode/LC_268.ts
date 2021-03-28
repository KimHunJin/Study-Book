function missingNumber(nums: number[]): number {
    let result: number = nums.length;
    nums.sort((a, b) => a-b).every((it, index) => {
        if (it !== index) {
            result = index;
            return false;
        } else {
            return true;
        }
    });

    return result;
};
