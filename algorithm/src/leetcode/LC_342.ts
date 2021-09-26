function isPowerOfFour(n: number): boolean {

    let rn = n;

    while (rn >= 1) {
        if (rn % 4 === 0) {
            rn = rn / 4;
        } else {
            break;
        }
    }

    return rn === 1;
};
