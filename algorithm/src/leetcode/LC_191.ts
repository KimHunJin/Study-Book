function hammingWeight(n: number): number {
    const nString = n.toString(2);
    let result = 0;
    for (let i=0; i<nString.length; i++) {
        if (Number(nString[i]) === 1) {
            result++;
        }
    }
    return result;
};
