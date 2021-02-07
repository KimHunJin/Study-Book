function kLengthApart(nums: number[], k: number): boolean {

    let dis = -1;
    for (let i=0; i<nums.length; i++) {
        if (nums[i] === 1) {
            if (dis !== -1 && dis < k) {
                return false;
            }
            dis = 0;
        } else {
            if (dis !== -1) {
                dis++;
            }
        }
    }
    return true;
};
