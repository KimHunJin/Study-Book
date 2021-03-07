function letterCasePermutation(S: string): string[] {
    return letterCaseRecursion(S, 0, [])
};

function letterCaseRecursion(S: string, index: number, cases: string[]): string[] {
    if (S.length <= index) {
        return cases;
    }

    const letterCases = [];
    const currentChar = S[index];

    if (isNumber(currentChar)) {
        if (index === 0) {
            letterCases.push(`${currentChar}`);
        } else {
            cases.forEach(it => letterCases.push(`${it}${currentChar}`));
        }
    } else {
        if (index === 0) {
            letterCases.push(`${currentChar.toLowerCase()}`);
            letterCases.push(`${currentChar.toUpperCase()}`);
        } else {
            cases.forEach(it => {
                letterCases.push(`${it}${currentChar.toLowerCase()}`);
                letterCases.push(`${it}${currentChar.toUpperCase()}`);
            })
        }
    }

    return letterCaseRecursion(S, index + 1, letterCases);
}

function isNumber(s: string): boolean {
    if (s >= '0' && s <= '9') {
        return true;
    }

    return false;
}
