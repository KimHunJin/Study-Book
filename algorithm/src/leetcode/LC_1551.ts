function minOperations(n: number): number {
    let result = 0;

    for (let i=1; i<n; i+=2) {
        result = result + n - i;
    }

    return result;
};
