// time over
function concatenatedBinary(n: number): number {
    let result = "";
    const modulo = Math.pow(10, 9) + 7;
    let i = 0;

    for (let i=1; i<=n; i++) {
        result += i.toString(2);

        if (parseInt(result, 2) > modulo) {
            result = (parseInt(result ,2) % modulo).toString(2);
        }
    }

    return parseInt(result, 2) % modulo;
};
