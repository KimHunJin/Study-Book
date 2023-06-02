/**
https://leetcode.com/contest/weekly-contest-302/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

배열의 index별 각 숫자의 자릿수를 합쳤을 때 나오는 숫자가 같은 수가 2개 이상 있을 경우
2개의 숫자를 합친 결과가 가장 큰 값을 반환
만약 같은 숫자가 2개이상 없다면 -1을 리턴


ex) [18, 43, 36, 13, 7]

-> [1 + 8 = 9, 4 + 3 = 7, 3 + 6 = 9, 1 + 3 = 4, 7]
-> [9, 7, 9, 4, 7]
-> index 0과 index 2가 9로 같고, index 1과 index 5가 7로 같음
-> sum이 9인 두 수의 합 = 18 + 36 = 54
-> sum이 7인 두 수의 합 = 43 + 7 = 50
-> 젤 큰 수 54 반환
*/

function maximumSum(nums: number[]): number {
    const arr = []
    nums.forEach((num) => {
        const numString = num + ''
        const sum = [...numString].reduce((acc, cur) => {
            return acc + Number(cur) // 각 자리수를 합침
        }, 0)
        
        if (arr[sum] !== undefined) {
            arr[sum].push(num) // 이미 합친 값의 key가 있다면 배열에 원래 값 추가
        } else {
            arr[sum] = [num] // 합친 값을 key로 하여 배열 생성해서 원래 값을 추가
        }
    })
    
    const pairArr = arr.filter((sum) => sum.length > 1) // sum이 2개 이상인것만 정렬
    const result = pairArr.reduce((acc, cur) => {
        const sortArray = cur.sort((a,b) => b-a) // pairArr의 저장된 수를 내림차순으로 정렬
        const highNumSum = sortArray[0] + sortArray[1]
        return Math.max(acc, highNumSum)
    }, -1) // 초기 값을 -1로 설정했기 때문에 빈 배열일 경우 -1 반환
    return result
};
