function lengthOfLIS(nums: number[]): number {
    const dp = Array(nums.length).fill(1);
    let result = 1;

    for (let i=0; i<nums.length; i++) {
        for (let j=0; j<i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
                result = Math.max(dp[i], result);
            }
        }
    }

    return result;

};
