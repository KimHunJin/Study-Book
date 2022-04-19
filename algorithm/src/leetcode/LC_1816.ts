function truncateSentence(s: string, k: number): string {
    return s.split(' ').reduce((prev, it, index) => index < k ? prev + " " + it : prev);
};
