function combinationSum4(nums: number[], target: number): number {

    const arr = [];

    for (let i=0; i<=target; i++) {
        arr[i] = 0;
    }

    const sortedNums = nums.sort((a,b) => a-b);

    arr[0] = 1;

    for (let i=1; i<=target; i++) {
        for (let j=0; j<sortedNums.length; j++) {
            const n = sortedNums[j];
            if (i - n >= 0) {
                arr[i] += arr[i-n];
            }
        }
    }

    return arr[target];
};
