function maximumUnits(boxTypes: number[][], truckSize: number): number {
    const arr = [];
    boxTypes.forEach(box => {
        for (let i=0; i<box[0]; i++) {
            arr.push(box[1]);
        }
    });

    const sortArr = arr.sort((a,b) => b-a);

    let result = 0;

    for (let i=0; i<truckSize; i++) {
        if (!arr[i]) {
            break;
        }
        result += arr[i];
    }

    return result;
};
