function solution(play_list, listen_time) {
    var answer = 0;

    var sum = play_list.reduce((a, b) => a + b);
    if (listen_time >= sum) {
        return play_list.length;
    }

    var playCount = [];
    var playTime = [];
    var remainingTime = listen_time - 1;
    var j = 1;
    var count = 1;
    while (remainingTime > 0) {
        remainingTime -= play_list[j % play_list.length];
        j++;
        count++;
    }
    playCount[0] = count;
    playTime[0] = remainingTime;
    if (playCount[0] > answer) {
        answer = playCount[0];
    }


    for (var i = 1; i < play_list.length; i++) {
        var pc = playCount[i-1] - 1;
        var pt = playTime[i-1] + play_list[i];

        var nextIndex = i + pc
        while(pt > 0) {
            pt -= play_list[nextIndex % play_list.length];
            pc++;
            nextIndex++;
        }
        playCount[i] = pc;
        playTime[i] = pt;
        if (playCount[i] > answer) {
            answer = playCount[i];
        }
    }

    if (answer > play_list.length) {
        answer = play_list.length;
    }

    return answer;
}

console.log(
    solution([2, 3, 1, 4], 3)
)

console.log(
    solution([1, 2, 3, 4], 5)
);

console.log(
    solution([1, 2, 3, 4], 20)
)
