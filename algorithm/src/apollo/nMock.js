function solution(h, w, n, board) {
    var answer = 0;

    for (var y = 0; y < h; y++) {
        for (var x = 0; x < w; x++) {
            if (board[y][x] === "1") {
                answer += find(x, y, board, h, w, n);
            }
        }
    }

    return answer;
}

function find(x, y, board, h, w, mockN) {
    var answer = 0
    for (var dic = 0; dic < 4; dic++) {
        if (isStart(dic, x, y, board, h, w)) {
            if (findMock(dic, x, y, 1, h, w, mockN, board)) {
                answer++;
            }
        }
    }
    return answer;
}

function findMock(dic, x, y, n, h, w, mockN, board) {
    var moveX = [0, 1, -1, 1];
    var moveY = [1, 0, 1, 1];

    if (n > mockN) {
        return false;
    }

    var movingX = x + moveX[dic];
    var movingY = y + moveY[dic];

    if (movingX < 0 || movingY < 0) {
        return n === mockN;
    }

    if (movingX >= w) {
        return n === mockN;
    }

    if (movingY >= h) {
        return n === mockN;
    }

    if (board[movingY][movingX] === "1") {
        return findMock(dic, movingX, movingY, n + 1, h, w, mockN, board);
    }

    return n === mockN;
}

function isStart(dic, x, y, board, h, w) {
    // dic 0 down, 1 right, 2 left down, 3 right down
    var reverseX = [0, -1, 1, -1];
    var reverseY = [-1, 0, -1, -1];

    var checkX = x + reverseX[dic];
    var checkY = y + reverseY[dic];

    if (checkX < 0 || checkY < 0) {
        return true;
    }

    if (checkX >= w || checkY >= h) {
        return true;
    }

    return board[checkY][checkX] !== "1";
}

console.log(
    solution(
        7, 9, 4,
        ["111100000", "000010011", "111100011", "111110011", "111100011", "111100010", "111100000"]
    )
)


console.log(
    solution(
        5,5,5,
        ["11111","11111","11111","11111","11111"]
    )
)

console.log(
    solution(
        3,3,3,
        ["111","111","111"]
    )
)
