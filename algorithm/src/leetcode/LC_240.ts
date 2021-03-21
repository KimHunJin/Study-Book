function searchMatrix(matrix: number[][], target: number): boolean {

    const map: Map<number, boolean> = new Map();

    for (let i=0; i<matrix.length; i++) {
        for (let j=0; j<matrix[i].length; j++) {
            map.set(matrix[i][j], true);
        }
    }

    return map.has(target);
};
