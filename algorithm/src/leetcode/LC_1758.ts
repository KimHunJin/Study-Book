function minOperations(s: string): number {
    let s0 = 0;
    let s1 = 0;
    for (let i=0; i<s.length; i++) {

        if (i % 2 === 0) {
            // 짝수
            if (s[i] === '0') {
                s1++;
            } else {
                s0++;
            }
        } else {
            // 홀수
            if (s[i] === '0') {
                s0++;
            } else {
                s1++;
            }
        }
    }
    
    return Math.min(s0, s1);
};
