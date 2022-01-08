function minCharacters(a: string, b: string): number {
    const aLen = a.length;
    const bLen = b.length;
    
    const aArray = Array.from({length: 26}, () => 0);
    const bArray = Array.from({length: 26}, () => 0);
    
    for (let i=0; i<aLen; i++) {
        const c = a[i].charCodeAt(0) - 97;
        aArray[c]++;
    }
    
    for (let i=0; i<bLen; i++) {
        const c = b[i].charCodeAt(0) - 97;
        bArray[c]++;
    }
    
    let best = 0;
    let sumA = 0;
    let sumB = 0;

    
    for (let i=0; i<26; i++) {
        best = Math.max(best, aArray[i] + bArray[i]);
    }

    
    for (let i=0; i<25; i++) {
        sumA += aArray[i];
        sumB += bArray[i];
        best = Math.max(best, sumA-sumB+bLen, sumB-sumA+aLen);
    }
    
    return aLen + bLen - best;
};