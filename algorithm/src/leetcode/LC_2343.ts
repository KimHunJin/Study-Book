/**
https://leetcode.com/contest/weekly-contest-302/problems/query-kth-smallest-trimmed-number/

nums와 queries가 주어짐
queries는 [찾을 index, 잘라낼 문자열 개수] 로 구성됨
문자열은 뒤에서부터 잘라내기 시작
잘라낸 문자열로 숫자를 만들어, 찾을 index 번째로 작은 수의 index를 찾아내는 문제

각각의 query는 독립적으로 동작해야 함

만약 숫자가 같은 경우 작은 index를 리턴

ex)
nums = ["102", "473", "251", "814"]
queries = [[1,1], [2,3], [4,2], [1,2]]

query[0] = [1,1]
뒤에서부터 1개를 잘라내어 1번째 작은 수의 index를 구하기
[2, 3, 1, 4]
제일 작은 수는 1로 index는 2에 해당

query[1] = [2,3]
뒤에서부터 3개를 잘라내어 2번째 작은 수의 index 구하기
[102, 473, 251, 814]
두번째 작은 수는 251로 index는 2에 해당

query[2] = [4,2]
뒤에서부터 2개를 잘라내어 4번째로 작은 수의 index 구하기
[02, 73, 51, 14]
4번째 작은 수는 73으로 index는 1에 해당

query[3] = [1,2]
뒤에서부터 2개를 잘라내어 1번째로 작은 수의 index 구하기
[2, 73, 51, 14]
1번째 작은 수는 2로 index는 0에 해당

즉 결과는 [2, 2, 1, 0]

*/
function smallestTrimmedNumbers(nums: string[], queries: number[][]): number[] {

    // {잘라낸 수, 기존 index}의 형태를 가지는 배열로 변경
    const result = queries.map((query) => {
        const trimCount = query[1]
        const smallIndex = query[0] - 1
        
        const trimmedArray = nums.map((num, idx) => {
            return {
                num: BigInt(num.slice(-trimCount)), // 64비트를 넘어가는 수가 있어 BigInt 사용
                idx: idx
            }
        })

        // 잘라낸 수를 기준으로 오름차순 정렬 하고, 만약 두 수가 같은 경우 idx를 기준으로 idx가 작은 순서로 정렬
        const sortedArray: {num: bigint, idx: number}[] = [...trimmedArray].sort((a,b) => {
            if (a.num == b.num) {
                return a.idx - b.idx
            } else {
                if (a.num > b.num) {
                    return 1
                } else {
                    return -1
                }
            }
        })
        
        const smallByIndex = sortedArray[smallIndex].idx        
        return smallByIndex
    })
    return result
};
