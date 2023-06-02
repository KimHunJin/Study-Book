/**

https://leetcode.com/contest/weekly-contest-302/problems/maximum-number-of-pairs-in-array/

같은 숫자 두개씩 뺐을 때 뺀 횟수와 남아있는 숫자의 수를 구하는 문제

*/
function numberOfPairs(nums: number[]): number[] {
    const arr = []
    const result = nums.reduce((acc, num) => {
        if (arr[num]) {
            arr[num]++
        } else {
            arr[num] = 1
        }
        
        if (arr[num] === 2) {
            arr[num] = 0
            return acc + 1
        }
        return acc
    }, 0)
    
    const remains = arr.filter(it => it > 0).length
    
    return [result, remains]
    
};
