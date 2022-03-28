function findCenter(edges: number[][]): number {
    const length = edges.length;
    const node = Array.from({length: length + 2}, () => 0);
    edges.forEach(edge => {
        const s = edge[0];
        const e = edge[1];
        
        node[s]++;
        node[e]++;
    })
    
    return node.findIndex(it => it === length);
};
