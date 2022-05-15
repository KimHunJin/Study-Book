function maxIceCream(costs: number[], coins: number): number {
    let count = 0;
    costs.sort((a, b) => a-b).some(cost => {
        if (coins >= cost) {
            coins -= cost;
            count++;
        } else {
            return false;
        }
    });

    return count;
};