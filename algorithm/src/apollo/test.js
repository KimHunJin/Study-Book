function solution(table) {
    var answer = 0;
    var maxNumber = 0;
    var currentNumber = 0;

    var size = table[0].length;
    var correctResult = Math.pow(2, size) - 1;

    var intTable = [];
    for (var i = 0; i < table.length; i++) {
        var sum = 0;
        for (var j = 0; j < table[i].length; j++) {
            if (table[i][j] === "O") {
                sum += (Math.pow(2, size - 1 - j));
            }
        }
        intTable[i] = sum;
    }

    while (maxNumber !== correctResult) {
        intTable.map((number, index) => {
            var changeNumber = currentNumber | number;
            if (maxNumber < changeNumber) {
                maxNumber = changeNumber;
            }
        })
        currentNumber = maxNumber;
        answer++;
    }

    return answer;
}

const table = ["XOXO", "OXXO", "XXOX", "XOOO"];
const table2 = ["OXXO", "XOXO", "XXOO"];
const table3 = ["OXOXO", "OOOOO", "XOXOX"];
const table4 = ["XXOOO", "OOXXX"];
const table5 = ["XOXXX", "XXXXX", "OXOOO"];
const table6 = ["XOXXX", "OXXXX", "XXOOO", "XOOOO"];
const table7 = ["OXXXX", "OOXXX", "OOOXX", "OOOOX", "XXOOO"];
const table8 = ["XXXXX", "OOOOO"];
const table9 = ["OXXXX", "OOXXX", "OXOXO", "OXOOX"];
const table10 = ["OOOXX", "XOOOX", "OXXXO"];

console.log(solution(table));
console.log(solution(table2));
console.log(solution(table3));
console.log(solution(table4));
console.log(solution(table5));
console.log(solution(table6));
console.log(solution(table7));
console.log(solution(table8));
console.log(solution(table9));
console.log(solution(table10));
