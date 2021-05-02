function halvesAreAlike(s: string): boolean {

    const size = s.length;
    const half = size / 2;

    const testCase = ['a','e','i','o','u','A','E','I','O','U'];

    let aVowels = 0;
    let bVowels = 0;


    for (let i=0; i<size; i++) {
        const c = s[i];

        if(testCase.find(t => t === c)) {
            if (i < half) {
                aVowels++;
            } else {
                bVowels++;
            }
        }
    }

    return aVowels === bVowels;
};
