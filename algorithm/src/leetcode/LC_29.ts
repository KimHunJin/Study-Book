function divide(dividend: number, divisor: number): number {
    const value = dividend / divisor;
    let result = value >= 0 ? Math.floor(value) : Math.ceil(value);

    if (result > Math.pow(2, 31) - 1) {
        return Math.pow(2, 31) - 1;
    }
    return result;
};
