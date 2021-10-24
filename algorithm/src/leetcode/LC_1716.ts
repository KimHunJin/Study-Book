function totalMoney(n: number): number {

    return Array.from({length: n}, (_, index) => index + 1).reduce((acc, item, index) => (
        acc + item - (Math.floor(index / 7) * 6)
    ));
};
