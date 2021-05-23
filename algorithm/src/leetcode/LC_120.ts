function minimumTotal(triangle: number[][]): number {

    let result = 99999999;

    for (let i=0; i<triangle.length; i++) {
        const length = triangle[i].length;
        for (let j=0; j<length; j++) {
            const num = triangle[i][j];
            if (i > 0) {
                if (j === 0) {
                    triangle[i][j] = triangle[i-1][j] + num;
                } else if(j === length - 1) {
                    triangle[i][j] = triangle[i-1][j-1] + num;
                } else {
                    triangle[i][j] = Math.min(triangle[i-1][j-1], triangle[i-1][j]) + num;
                }
            }
        }

        if ( i=== triangle.length - 1) {
            console.log(triangle[i]);
            for (let j=0; j<length; j++) {
                result = Math.min(result, triangle[i][j]);
            }
        }
    }


    return result;
};
