function minimumOperations(nums: number[]): number {
    let result = 0
    const sortedArr = [...nums].sort((a,b) => a-b)

    for (let i=0;i<sortedArr.length; i++) {
        const n = sortedArr[i];
        if (n <= 0) {
            continue
        }

        for (let j=i+1; j<sortedArr.length; j++) {
            sortedArr[j] = sortedArr[j] - n
        }

        for (let j=0; j<nums.length; j++) {
            if (nums[j] > 0) {
                nums[j] = nums[j] - n
            }
        }
        result++
    }

    return result
};
