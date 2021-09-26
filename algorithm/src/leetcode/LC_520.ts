function detectCapitalUse(word: string): boolean {
    let firstUpper = false;
    let upper = 0;
    let lower = 0;

    [...word].forEach((w, index) => {
        if (w === w.toUpperCase()) {
            upper++;
            if (index === 0) {
                firstUpper = true;
            }
        }
        if (w === w.toLowerCase()) {
            lower++;
        }
    })

    if (firstUpper) {
        return upper === 1 || lower === 0;
    }

    return upper === 0 || lower === 0;
};
