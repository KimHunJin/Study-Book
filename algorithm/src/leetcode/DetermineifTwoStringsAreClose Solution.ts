function closeStrings(word1: string, word2: string): boolean {

    if (word1.length !== word2.length) {
        return false;
    }

    const m1: Map<string, number> = new Map();
    const m2: Map<string, number> = new Map();

    for (let i=0; i<word1.length; i++) {
        const char1 = word1[i];
        const char2 = word2[i];

        if (m1.has(char1)) {
            m1.set(char1, m1.get(char1) + 1);
        } else {
            m1.set(char1, 1);
        }

        if (m2.has(char2)) {
            m2.set(char2, m2.get(char2) + 1);
        } else {
            m2.set(char2, 1);
        }
    }

    const w1 = [...m1.keys()];
    const w2 = [...m2.keys()];

    // 모든 원소가 양측에 포함됐는지 확인
    for (let i=0; i<w1.length; i++) {
        if (!w2.some(w => w1[i] === w)) {
            return false;
        }
        if (!w1.some(w => w2[i] === w)) {
            return false;
        }
    }

    // 같은 개수인지 확인

    const n1 = [...m1.values()].sort((a,b) => a-b);
    const n2 = [...m2.values()].sort((a,b) => a-b);

    for (let i=0; i<n1.length; i++) {
        if (n1[i] !== n2[i]) {
            return false;
        }
    }

    return true;

};
