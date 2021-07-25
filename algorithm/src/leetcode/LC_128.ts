function longestConsecutive(nums: number[]): number {

    const s = new Set(nums);

    let max = 0;

    for(let num of nums) {
        if (s.has(num-1)) {
            continue;
        }

        let size = 1;
        while(s.has(num + size)) {
            size++;
        }

        max = Math.max(max, size);
    }

    return max;

};
