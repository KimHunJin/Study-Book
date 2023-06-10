function repeatedCharacter(s: string): string {
    const map = new Map()
    let result = ''
    for (let i=0; i<s.length; i++) {
        if (map.get(s[i])) {
            result = s[i]
            break
        } else {
            map.set(s[i], true)
        }
    }

    return result
};
