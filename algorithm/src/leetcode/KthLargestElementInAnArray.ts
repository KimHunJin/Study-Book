function findKthLargest(nums: number[], k: number): number {
    return nums.sort((a, b) => b-a)[k-1];
};
