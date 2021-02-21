function findLHS(nums: number[]): number {
    const map: Map<number, number> = new Map();

    nums.forEach(it => {
        if (map.has(it)) {
            map.set(it, map.get(it) + 1);
        } else {
            map.set(it, 1);
        }
    });

    let result = 0;

    const keys = [...map.keys()].sort((a, b) => a-b);
    for (let i=0; i<keys.length; i++) {
        const key = keys[i];
        if (map.has(key + 1)) {
            result = Math.max(result, map.get(key) + map.get(key + 1));
        }
    }

    return result;
};
