function scoreOfParentheses(S: string): number {
    let stackLevel: number = 0;
    const calculatorMemory: number[] = [];

    // initialize
    for (let i=0; i<=50; i++) {
        calculatorMemory[i] = 0;
    }

    for (let i=0; i<S.length; i++) {
        const c = S[i];
        if (c === '(') {
            stackLevel++;
        } else {
            let value = 1;
            if (calculatorMemory[stackLevel] !== 0) {
                value = calculatorMemory[stackLevel] * 2;
                calculatorMemory[stackLevel] = 0;
            }
            stackLevel--;
            calculatorMemory[stackLevel] += value;
        }
    }

    return calculatorMemory[0];
};
