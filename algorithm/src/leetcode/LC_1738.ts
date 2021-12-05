function kthLargestValue(matrix: number[][], k: number): number {

    const m = matrix.length;
    const n = matrix[0].length;

    const newMatrix = Array.from({length: m}, () => Array.from({length: n}, () => 0));
    
    
    const result = [];
    
    newMatrix[0][0] = matrix[0][0];
    
    for (let i=0; i<m; i++) {
        for (let j=0; j<n; j++) {
            let cell = matrix[i][j];
            if (i > 0) {
                cell = cell ^ newMatrix[i-1][j];
            }
            if (j > 0) {
                cell = cell ^ newMatrix[i][j-1];
            }
            if (i > 0 && j > 0) {
                cell = cell ^ newMatrix[i-1][j-1];
            }
            newMatrix[i][j] = cell;
            result.push(cell);
        }
    }
    
    result.sort((a,b) => b-a);
    return result[k-1];
};
