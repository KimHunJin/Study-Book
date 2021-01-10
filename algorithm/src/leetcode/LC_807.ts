function maxIncreaseKeepingSkyline(grid: number[][]): number {

    const topOrBottomView: number[] = [];
    const leftOrRightView: number[] = [];

    const size = grid.length;

    for (let i=0; i<size; i++) {
        let topOrBottomMax = 0;
        let leftOrRightMax = 0;

        for (let j=0; j<size; j++) {
            topOrBottomMax = grid[j][i] > topOrBottomMax ? grid[j][i] : topOrBottomMax;
            leftOrRightMax = grid[i][j] > leftOrRightMax ? grid[i][j] : leftOrRightMax;
        }

        topOrBottomView[i] = topOrBottomMax;
        leftOrRightView[i] = leftOrRightMax;
    }

    const newGrid: number[][] = new Array(size);
    for (let i=0; i<size; i++) {
        newGrid[i] = new Array(size);
    }

    let findIndex = 0;

    for (let i=0; i<size; i++) {
        if (topOrBottomView[0] === leftOrRightView[i]) {
            findIndex = i;
        }
    }

    for (let i=0; i<size; i++) {
        newGrid[i][0] = leftOrRightView[i];
        newGrid[findIndex][i] = topOrBottomView[i];
    }

    for (let i=0; i<size; i++) {
        const leftOrRightMax = newGrid[i][0];
        for (let j=0; j<size; j++) {
            const topOrBottomMax = newGrid[findIndex][j];
            newGrid[i][j] = Math.min(leftOrRightMax, topOrBottomMax);
        }
    }

    let sum = 0;

    for (let i=0; i<size; i++) {
        for (let j=0; j<size; j++) {
            sum += newGrid[i][j] - grid[i][j];
        }
    }

    return sum;
};
