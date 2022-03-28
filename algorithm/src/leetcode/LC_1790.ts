function areAlmostEqual(s1: string, s2: string): boolean {
    if (s1 === s2) {
        return true;
    }
    
    const diffIndex = [];
    for (let i=0; i<s1.length; i++) {
        if (s1[i] !== s2[i]) {
            diffIndex.push(i);
        }
        
        if (diffIndex.length > 2) {
            return false;
        }
    }
    
    if (diffIndex.length < 2) {
        return false;
    }
    
    if (s1[diffIndex[0]] !== s2[diffIndex[1]]) {
        return false;
    }
    
    if (s1[diffIndex[1]] !== s2[diffIndex[0]]) {
        return false;
    }
    
    return true;
};
