function checkOnesSegment(s: string): boolean {
    let leading = false;
    let segment = true;
    
    for (let i=0; i<s.length; i++) {
        if (i === 0 && s[i] === '0') {
            return false;
        }
        
        if (s[i] === '0') {
            segment = false;
        } else {
            if (segment === false) {
                return false;
            }
        }
        
    }
    return true;
    
};
