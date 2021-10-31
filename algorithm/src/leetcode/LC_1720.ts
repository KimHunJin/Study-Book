function decode(encoded: number[], first: number): number[] {
    const answer = Array.from({length: encoded.length + 1}, () => 0);
    answer[0] = first;

    for (let i=1; i<answer.length; i++) {
        answer[i] = answer[i-1] ^ encoded[i-1];
    }

    return answer;
};
