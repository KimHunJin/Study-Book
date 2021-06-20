class NumMatrix {

    prefix: number[][];

    constructor(matrix: number[][]) {

        this.prefix = matrix;

        for (let i=0; i<matrix.length; i++) {
            for (let j=0; j<matrix[i].length; j++) {
                const beforeX = i-1;
                const beforeY = j-1;

                let sum = matrix[i][j];

                if (beforeX >= 0) {
                    sum += matrix[beforeX][j];
                }

                if (beforeY >= 0) {
                    sum += matrix[i][beforeY];
                }

                if (beforeX >=0 && beforeY >= 0) {
                    sum -= matrix[beforeX][beforeY];
                }

                this.prefix[i][j] = sum;
            }
        }
    }

    sumRegion(row1: number, col1: number, row2: number, col2: number): number {
        const minX = Math.min(row1, row2) - 1;
        const maxX = Math.max(row1, row2);

        const minY = Math.min(col1, col2) - 1;
        const maxY = Math.max(col1, col2);

        let result = this.prefix[maxX][maxY];

        if (minX >= 0) {
            result -= this.prefix[minX][maxY];
        }

        if (minY >= 0) {
            result -= this.prefix[maxX][minY];
        }

        if (minX >=0 && minY >=0) {
            result += this.prefix[minX][minY];
        }

        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
