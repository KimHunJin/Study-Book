function isIsomorphic(s: string, t: string): boolean {
    const wordS: Map<string, string> = new Map();
    const wordT: Map<string, string> = new Map();

    if (s.length !== t.length) {
        return false;
    }

    if (s === t) {
        return true;
    }

    for (let i=0; i<s.length; i++) {
        const sc = s[i];
        const tc = t[i];

        if (!wordS.has(sc)) {
            wordS.set(sc, tc);
        }

        if (!wordT.has(tc)) {
            wordT.set(tc, sc);
        }

        if (wordS.get(sc) !== tc || wordT.get(tc) !== sc) {
            return false;
        }
    }

    return true;
};
