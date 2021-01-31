function countVowelStrings(n: number): number {
    const nums = [0,0,0,0,1];

    while(n-- > 0) {
        for (let i=0; i<5; i++) {
            let sum = 0;
            for (let j=i; j<5; j++) {
                sum += nums[j];
            }
            nums[i] = sum;
        }
    }

    return nums.reduce((acc, curr) => acc + curr);
};
