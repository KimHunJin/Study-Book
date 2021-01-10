function topKFrequent(nums: number[], k: number): number[] {

    const frequent: N[] = [];

    for (let i=0; i<nums.length; i++) {
        if (frequent.findIndex(it => it.n === nums[i]) >= 0) {
            frequent.find(it => it.n === nums[i]).count++;
        } else {
            frequent.push(new N(1, nums[i]));
        }
    }

    frequent.sort((a, b) => b.count - a.count);

    return frequent.filter((_, index) => index < k).map(it => it.n);
};

class N {
    count: number;
    n: number;

    constructor(count: number, n: number) {
        this.count = count;
        this.n = n;
    }
}
