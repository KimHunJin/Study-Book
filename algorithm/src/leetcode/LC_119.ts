function getRow(rowIndex: number): number[] {

    const arr = Array.from({length: rowIndex + 1}, (_, index) => {
        return Array.from({length: index + 1}, () => 1);
    })

    for (let i=0; i<arr.length; i++) {
        for (let j=0; j<arr[i].length; j++) {
            if (i !== 0 && j !== 0 && j !== arr[i].length - 1) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }
    }

    return arr[rowIndex];
};
