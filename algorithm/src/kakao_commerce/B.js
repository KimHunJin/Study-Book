function solution(m, v) {
    var answer = 0;

    var board = {
        height: 1,
        remaindBoard: [Number(m)]
    }

    for (var i = 0; i < v.length; i++) {
        if (board.remaindBoard[board.height-1] - v[i] >= 0) {
            var height = board.height -1;
            for (var k = board.height-1; k >= 0; k--) {
                if (board.remaindBoard[k] - v[i] >= 0) {
                } else {
                    height = k+1;
                    break;
                }
            }
            board.remaindBoard[height] = board.remaindBoard[height] - Number(v[i]);
        } else {
            board.height++;
            board.remaindBoard.push(Number(m) - Number(v[i]));
        }
    }

    answer = board.height;

    return answer;
}

console.log(solution(4, [2, 3, 1]));
console.log(solution(4, [3, 2, 3, 1]));
