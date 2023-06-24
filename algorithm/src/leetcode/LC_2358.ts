function maximumGroups(grades: number[]): number {
    grades.sort((a,b) => a-b)
    const size = grades.length

    let max = 0
    let count = 0
    for (let i=1; i<=size; i++) {
        max += i;
        if (max > size) {
            break
        }
        count++
    }
    return count

};
