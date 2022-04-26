function arraySign(nums: number[]): number {
    const sum = nums.reduce((acc, cur) => acc * cur);
    
    if (sum > 0) {
        return 1;
    }
    
    if (sum < 0) {
        return -1;
    }
    
    return 0;
};
