function titleToNumber(columnTitle: string): number {
    const codeNumber = 'A'.charCodeAt(0) - 1;
    let result = 0;
    for (let i=columnTitle.length - 1, j=0; i>=0; i--, j++) {
        const charNumber = columnTitle.charCodeAt(i) - codeNumber;
        result = result + (Math.pow(26, j) * charNumber);
    }

    return result;
};
