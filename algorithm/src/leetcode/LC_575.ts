function distributeCandies(candyType: number[]): number {
    const eat = candyType.length / 2;
    const types = candyType.filter((it, index) => candyType.indexOf(it) === index).length;

    return eat > types ? types : eat;
};
