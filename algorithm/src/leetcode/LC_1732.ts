function largestAltitude(gain: number[]): number {
    let highest = 0;

    let high = 0;

    for(let i=0; i<gain.length; i++) {
        high += gain[i];
        if (highest < high) {
            highest = high;
        }
    }

    return highest;
};
