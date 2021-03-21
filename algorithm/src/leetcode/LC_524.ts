/**
 * 정렬 기준이 뭐지..?
 * @param s
 * @param dictionary
 */
function findLongestWord(s: string, dictionary: string[]): string {

    let result = "";

    const sMap = new Map<string, number>();
    const newDictionary = dictionary.sort((a, b) => {
        if (a.length > b.length) {
            return 1;
        } else if (a.length < b.length) {
            return -1;
        } else {
            return (a as any > b as any) - (a as any < b as any);
        }
    });

    for(let i=0; i<s.length; i++) {
        const c = s[i];
        if (sMap.has(c)) {
            sMap.set(c, sMap.get(c) + 1);
        } else {
            sMap.set(c, 1);
        }
    }

    for (let i=0; i<newDictionary.length; i++) {
        const tempMap = new Map(sMap);
        const dic = newDictionary[i];
        let isCollect: boolean = true;
        for (let j=0; j<dic.length; j++) {
            const c = dic[j];
            if (tempMap.has(c) && tempMap.get(c) > 0) {
                tempMap.set(c, tempMap.get(c) - 1);
            } else {
                isCollect = false;
                break;
            }
        }
        if (isCollect) {
            result = dic;
            break;
        }
    }
    return result;
};
