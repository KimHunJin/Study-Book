function checkIfPangram(sentence: string): boolean {
    if (sentence.length < 26) {
        return false;
    }

    const alphabets = {};
    let sum = 0;

    for (let i=0; i<sentence.length; i++) {
        const c = sentence[i];

        if (alphabets[c]) {
            continue;
        } else {
            alphabets[c] = 1;
            sum++;
        }

        if (sum >= 26) {
            return true;
        }
    }

    return false;

};