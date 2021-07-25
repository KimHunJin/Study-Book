function maxArea(h: number, w: number, horizontalCuts: number[], verticalCuts: number[]): number {

    const mod = 10**9 + 7;

    horizontalCuts.push(h);
    verticalCuts.push(w);

    horizontalCuts.sort((a,b) => a-b);
    verticalCuts.sort((a,b) => a-b);

    let height: number = horizontalCuts[0];
    let width: number = verticalCuts[0];

    for (let i=0; i<horizontalCuts.length - 1; i++) {
        height = Math.max(height, horizontalCuts[i+1] - horizontalCuts[i])
    }

    for (let i=0; i<verticalCuts.length - 1; i++) {
        width = Math.max(width, verticalCuts[i+1] - verticalCuts[i])
    }

    return (width * height) % mod;

};
