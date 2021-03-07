function kWeakestRows(mat: number[][], k: number): number[] {

    return mat.map((row, index) => ({
        index: index,
        strong: row.reduce((a, col) => a + col)
    })).sort((a,b) => a.strong - b.strong)
        .slice(0, k)
        .map(it => it.index);
};
