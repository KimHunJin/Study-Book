function findErrorNums(nums: number[]): number[] {
    const result= [];

    const isIn: boolean[] = [];
    isIn[0] = true;
    nums.forEach((_, index) => isIn[index+1] = false);

    let twiceNum;
    nums.forEach(it => {
        if(isIn[it]) {
            twiceNum = it;
        } else {
            isIn[it] = true;
        }
    });

    const lossNum = isIn.findIndex(it => !it);

    result.push(twiceNum);
    result.push(lossNum);

    return result;
};
