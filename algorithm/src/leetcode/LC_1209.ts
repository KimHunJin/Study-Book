// 실패
function removeDuplicates(s: string, k: number): string {

    let wordCount = 1;
    const map: Map<string, {value: number}> = new Map();

    const valuesArray: {value: number}[] = [];

    for (let i=0; i<s.length; i++) {
        const c = s[i];
        if (!map.get(c)) {
            map.set(c, {value: wordCount});
        }

        let isLoop = true;
        while(isLoop) {
            let before = 1;
            if (i - before >= 0) {
                const beforeC = s[i - before];
                // 직전값이 같다면
                if (beforeC === c) {
                    const maxBeforeCValue = map.get(beforeC).value * k;
                    // 이미 k번 중복이라면
                    if (valuesArray[i-before].value === maxBeforeCValue) {
                        valuesArray[i] = {value: map.get(c).value};
                    } else {
                        valuesArray[i] = valuesArray[i-before];
                        valuesArray[i].value+=map.get(c).value;
                    }
                    isLoop = false;
                } else {
                    const maxBeforeCValue = map.get(beforeC).value * k;
                    // 직전 값이 연속된 문자였다면
                    if (valuesArray[i-before].value === maxBeforeCValue) {
                        before+=k;
                    } else {
                        valuesArray[i] = {value: map.get(c).value};
                        isLoop = false;
                    }
                }
            } else {
                valuesArray[i] = {value: map.get(c).value};
                isLoop = false;
            }
        }
    }

    let result = "";
    for (let i=0; i<s.length; i++) {
        const c = s[i];
        const maxValue = map.get(c).value * k;
        if (valuesArray[i].value !== maxValue) {
            result += c;
        }
    }

    return result;
};
