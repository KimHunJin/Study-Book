function maxAreaOfIsland(grid: number[][]): number {

    const dx = [0, 0, 1, -1];
    const dy = [1, -1, 0, 0];

    let result = 0;

    for (let i=0; i<grid.length; i++) {
        for (let j=0; j<grid[i].length; j++) {

            if (grid[i][j] <= 0) {
                continue;
            }

            const q = [];
            q.push({x: j, y: i});
            let size = 0;

            while(q.length > 0) {
                const xy = q.shift();
                grid[xy.y][xy.x] = -1;
                size ++;

                for (let k=0; k<4; k++) {

                    const x = xy.x + dx[k];
                    const y = xy.y + dy[k];

                    if (x < 0 || x >= grid[i].length) {
                        continue;
                    }

                    if (y < 0 || y >= grid.length) {
                        continue;
                    }

                    if (grid[y][x] === 1) {
                        q.push({x: x, y: y});
                        grid[y][x] = -1;
                    }
                }
            }
            result = Math.max(result, size);
        }
    }

    return result;

};
