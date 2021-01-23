function solution(n, record) {
    var answer = [];

    var serverMap = new Map();

    for (var i=0; i<n; i++) {
        serverMap.set(i+1, {index: 0, names: []});
    }

    for (var i=0; i<record.length; i++) {
        var server = Number(record[i].split(' ')[0]);
        var name = record[i].split(' ')[1];

        console.log(server);
        console.log(name);

        if (serverMap.get(server).names.findIndex(it => it === name) === -1) {
            serverMap.get(server).names[serverMap.get(server).index % 5] = name;
            serverMap.get(server).index++;
        }
    }

    for (var i=0; i<n; i++) {
        if(serverMap.get(i+1).names.length > 0) {
            var nameArr = serverMap.get(i+1).names;
            var mapIndex = serverMap.get(i+1).index;
            for (var j=0; j<nameArr.length; j++) {
                answer.push(nameArr[(mapIndex + j)%nameArr.length])
            }
        }
    }

    return answer;
}

console.log(solution(1, ["1 fracta", "1 sina", "1 hana", "1 robel", "1 abc", "1 sina", "1 lynn"]));
