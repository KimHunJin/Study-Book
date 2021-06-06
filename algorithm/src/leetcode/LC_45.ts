function jump(nums: number[]): number {
    const result = Array.from({length: nums.length}, () => 10000);

    result[0] = 0;

    for (let i=0; i<nums.length; i++) {
        const jump = nums[i];

        for (let j=0; j<=jump; j++) {
            const d = i + j;
            if (d >= nums.length) {
                break;
            }
            result[d] = Math.min(result[d], result[i] + 1);
        }
    }

    return result[nums.length - 1];
};
