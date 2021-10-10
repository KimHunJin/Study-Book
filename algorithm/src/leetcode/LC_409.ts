function longestPalindrome(s: string): number {

    const map = {};
    const sLength = s.length;

    let result = 0;

    for (let i=0; i<s.length; i++) {
        const c = s[i]
        if (map.hasOwnProperty(c)) {
            map[c] = map[c] + 1;
        } else {
            map[c] = 1;
        }
    }

    Object.keys(map).forEach(k => {
        result = result + ((Math.floor(map[k] / 2)) * 2);
    })

    if (result >= sLength) {
        return result;
    }

    return result + 1;
};
