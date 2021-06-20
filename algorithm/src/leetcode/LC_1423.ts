function maxScore(cardPoints: number[], k: number): number {

    const length = cardPoints.length;
    const w = length - k;

    let sum = cardPoints.reduce((acc, i) => acc + i, 0);
    let min = sum;
    let total = sum;

    for (let i=0; i<k; i++) {
        sum -= cardPoints[i];
        sum += cardPoints[i + w];
        total += cardPoints[i + w];

        if (min > sum) {
            min = sum;
        }
    }

    return total - min;
};
