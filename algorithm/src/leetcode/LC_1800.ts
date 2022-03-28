function maxAscendingSum(nums: number[]): number {
    const sum = [];
    
    sum[0] = nums[0];
    for (let i=1; i<nums.length; i++) {
        if (nums[i] > nums[i-1]) {
            sum[i] = sum[i-1] + nums[i];
        } else {
            sum[i] = nums[i];
        }
    }
    
    return Math.max.apply(null, sum);
};
