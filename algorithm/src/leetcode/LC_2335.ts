function fillCups(amount: number[]): number {
    let sum = amount.reduce((acc, cur) => acc + cur, 0)
    let number = 0
    
    while(sum > 0) {
        
        const { max, min } = getIndex(amount)
        if (max === min) {
            number = number + amount[max]
            sum = sum - 1
            break
        } else {
            amount[min]--
            amount[max]--
            sum = sum - 2
            number += 1
        }
    }
    
    return number
};

function getIndex(amount: number[]): {max: number, min: number} {
    let min = 1000
    let minIdx

    let maxIdx = 0
    let max = 0
    
    for (let i=0; i<amount.length; i++) {
        if (max < amount[i]) {
            maxIdx = i
            max = amount[i]
        }
        
        if (min >= amount[i] && amount[i] > 0) {
            minIdx = i
            min = amount[i]
        }
    }
    
    return {
        max: maxIdx,
        min: minIdx
    }
}
