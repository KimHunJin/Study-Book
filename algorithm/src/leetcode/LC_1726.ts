function tupleSameProduct(nums: number[]): number {

    const map: Map<number, number> = new Map();

    for (let i=0; i<nums.length; i++) {
        for (let j=i+1; j<nums.length; j++) {
            const r = nums[i] * nums[j];

            if (map.has(r)) {
                map.set(r, map.get(r) + 1);
            } else {
                map.set(r, 1);
            }
        }
    }

    let result = 0;

    [...map.keys()].forEach(k => {
        const count = map.get(k);
        if (count >= 2) {
            result = result + (nCr(count, 2) * 8);
        }
    });

    return result;

};

function nCr(n: number, r: number): number {
    return fact(n) / (fact(r) * fact(n - r));
}

function fact(n): number {
    let r = 1;

    for (let i=2; i<=n; i++) {
        r *= i;
    }

    return r;
}
