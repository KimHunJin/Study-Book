function solution(next_student) {
    var answer = 0;
    var max = 0;

    var studentValue = [];
    for (var i = 0; i <= next_student.length; i++) {
        studentValue[i] = {
            count: -1,
            isVisit: false
        };
    }
    studentValue[0] = {
        count: 0,
        isVisit: true
    };

    for (var i = 1; i <= next_student.length; i++) {
        if (studentValue[i].count === -1) {
            var k = nextStudent(studentValue, i, next_student, 0, []);
            studentValue[i].count = k;
            studentValue[i].isVisit = true;
        }
        if (k >= max) {
            max = k;
            if (i > answer) {
                answer = i;
            }
        }
    }


    return answer;
}

function nextStudent(studentValue, studentIndex, next_student, count, visited) {

    // 루프
    if (visited.findIndex(it => it === studentIndex) !== -1) {
        return count;
    }

    visited.push(studentIndex);
    return nextStudent(studentValue, next_student[studentIndex-1], next_student, count + 1, visited);
}

console.log(solution([5, 9, 13, 1, 0, 0, 11, 1, 7, 12, 9, 9, 2]));
console.log(solution([6, 10, 8, 5, 8, 10, 5, 1, 6, 7]));
