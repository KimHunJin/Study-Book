function countBalls(lowLimit: number, highLimit: number): number {
    let max = 0;
    const result = [];
    for (let i=lowLimit; i<=highLimit; i++) {
        const n = i + "";
        let sum = 0;
        for (let j=0; j<[...n].length; j++) {
            sum += Number(n[j]);
        }
        
        if (result[sum]) {
            result[sum] = result[sum] + 1;
        } else {
            result[sum] = 1;
        }
        max = Math.max(max, result[sum]);
    }
    
    return max;
};
