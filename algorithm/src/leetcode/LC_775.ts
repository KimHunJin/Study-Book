function isIdealPermutation(nums: number[]): boolean {
    let global = 0;
    let local = 0;

    for (let i=0; i<nums.length; i++) {
        for (let j=i+1; j<nums.length; j++) {
            if (nums[i] > nums[j]) {
                global++;
            }
        }

        if (i < nums.length -1 && nums[i] > nums[i+1]) {
            local++;
        }
    }

    return global === local;
};
