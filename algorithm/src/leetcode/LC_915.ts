function partitionDisjoint(nums: number[]): number {
    let left = 0;
    let right = nums.length - 1;

    let rightMin = 10000000;

    while(true) {
        if (nums[left] > nums[right] || left === right) {
            break;
        }

        rightMin = Math.min(rightMin, nums[right]);
        right--;

    }

    const max = Math.max.apply(null, nums.slice(0, right + 1));
    if (max > rightMin) {
        for (let i=nums.length; i>=right; i--) {
            if (nums[i] < max) {
                right = i;
                break;
            }
        }
    }

    return right + 1;
};
