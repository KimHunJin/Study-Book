function longestNiceSubstring(s: string): string {

    let result = '';

    const map: Map<string, string> = new Map();
    for (let i=0; i<s.length; i++) {
        for (let j=i; j<=s.length; j++) {
            const subS = s.substring(i, j)
            if (isNice(subS) && result.length < subS.length) {
                result = subS;
            }
        }
    }

    return result;
};

function isNice(s: string) {
    const arr = Array.from({length: 130}, () => 0);
    for (let i=0; i<s.length; i++) {
        const c = s[i].charCodeAt(0);
        arr[c] = 1;
    }

    for (let i='A'.charCodeAt(0), j='a'.charCodeAt(0); i<='Z'.charCodeAt(0); i++, j++) {
        const xor = arr[i] ^ arr[j];
        if (!xor === false) {
            return false;
        }
    }
    return true;
}