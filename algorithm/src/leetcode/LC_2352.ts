function equalPairs(grid: number[][]): number {
    const size = grid.length;
    let result = 0

    let next = false
    for (let i=0; i<size; i++) {
        for (let j=0; j<size; j++) {
            let row = ''
            let column = ''
            for (let k=0; k<size; k++) {
                row = row + '-' + grid[i][k]
                column = column + '-' + grid[k][j]
            }
            if (row === column) {
                result++
            }
        }
    }
    return result
};


/**
(i,k) === (j,k)
(0,0) === (0,0)
(0,1) === (0,1)
(0,2) === (0,2)

(0,0) === (1,0)
(0,1) === (1,1)
(0,2) === (1,2)

(0,0) === (2,0)
(0,1) === (2,1)
(0,2) === (2,2))
 */
