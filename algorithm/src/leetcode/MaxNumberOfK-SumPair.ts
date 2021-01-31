function maxOperations(nums: number[], k: number): number {

    let count = 0;
    const isVisit: boolean[] = [];

    const diff: Map<number, number> = new Map();

    for (let i=0; i<nums.length; i++) {
        if (diff[nums[i]]) {
            diff[nums[i]]++;
        } else {
            diff[nums[i]] = 1;
        }
    }

    Object.keys(diff).forEach(it => {
        const dif = k - Number(it);
        if (diff[dif]) {
            let min = Math.min(diff[it], diff[dif]);

            if (Number(it) === dif) {
                min = Math.floor(min/2);
            }

            diff[it]-=min;
            diff[dif]-=min;
            count+=min;
        }
    })

    return count;
};
