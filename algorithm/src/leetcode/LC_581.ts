function findUnsortedSubarray(nums: number[]): number {
    const sortNums = nums.concat().sort((a, b) => a-b);
    let startIndex = 0;
    let lastIndex = -1;
    for (let i=0; i<nums.length; i++) {
        if (sortNums[i] !== nums[i]) {
            startIndex = i;
            break;
        }
    }

    for (let i=nums.length-1; i>=0; i--) {
        if (sortNums[i] !== nums[i]) {
            lastIndex = i;
            break;
        }
    }

    return lastIndex - startIndex + 1;
};
