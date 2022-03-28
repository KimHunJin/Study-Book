function secondHighest(s: string): number {
    const numbers = {};
    for (let i=0; i<s.length; i++) {
        if (!isNaN(Number(s[i]))) {
            numbers[s[i]] = 1;
        }
    }
    
    const keys = [...Object.keys(numbers)].sort((a,b) => Number(b) - Number(a));
        
    if (keys.length < 2) {
        return -1;
    }
    
    return Number(keys[1]);
    
};
