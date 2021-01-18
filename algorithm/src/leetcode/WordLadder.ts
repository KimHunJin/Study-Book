function ladderLength(beginWord: string, endWord: string, wordList: string[]): number {
    if (wordList.some(word => word === endWord) === false) {
        return 0;
    }

    const depth: number[] = [];
    const queue: string[] = [];

    queue.push(beginWord);
    depth[beginWord] = 1;

    while(queue.length !== 0) {
        const currentWord = queue.shift();
        const currentDepth = depth[currentWord];

        for(let i=0; i<wordList.length; i++) {
            const checkWord = wordList[i];
            if (isAvailableChangeWord(currentWord, checkWord)) {
                if (depth[checkWord]) {
                    if (depth[checkWord] > currentDepth + 1) {
                        depth[checkWord] = currentDepth + 1;
                        queue.push(checkWord);
                    }
                } else {
                    depth[checkWord] = currentDepth + 1;
                    queue.push(checkWord);
                }
            }
        }
    }

    return depth[endWord] ?? 0;

};

function isAvailableChangeWord(beginWord: string, checkWord: string) {
    const size = beginWord.length;
    let count = 0;
    for (let i=0; i<size; i++) {
        if (beginWord[i] !== checkWord[i]) {
            count++;
        }
    }

    return count === 1;
}
