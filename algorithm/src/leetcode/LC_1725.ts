function countGoodRectangles(rectangles: number[][]): number {
    let max = 0;
    const map = new Map();
    const m = rectangles.forEach(rec => {
        const square = Math.min(rec[0], rec[1])
        max = Math.max(square, max);

        if (map.has(square)) {
            map.set(square, map.get(square) + 1);
        } else {
            map.set(square, 1);
        }
    });

    return map.get(max);

};
