function squareIsWhite(coordinates: string): boolean {
    const en = (coordinates[0].charCodeAt(0) - 'a'.charCodeAt(0)) + 1;
    const num = Number(coordinates[1]);
    const sum = en + num;
    return sum % 2 !== 0;
};
