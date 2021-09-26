function findDuplicates(nums: number[]): number[] {

    const map = {};
    const duplicate: Set<number> = new Set();

    nums.forEach(n => {
        if (map[n]) {
            map[n] = map[n] + 1;
            duplicate.add(n);
        } else {
            map[n] = 1;
        }
    })

    return [...duplicate];
};
