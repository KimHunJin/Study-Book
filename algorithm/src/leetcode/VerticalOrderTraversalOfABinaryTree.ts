/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function verticalTraversal(root: TreeNode | null): number[][] {
    const nodes: {node: TreeNode, depth: number, level: number}[] = [];

    const map: Map<number, Map<number, number[]>> = new Map();


    let index = 0;

    nodes.push({
        node: root,
        level: 0,
        depth: 0
    });


    while(index < nodes.length) {
        const nodeInfo = nodes[index];
        const nodeLevel = nodeInfo.level;
        const node = nodeInfo.node;
        const nodeDepth = nodeInfo.depth;

        if (map.has(nodeLevel)) {

            if (map.get(nodeLevel).has(nodeDepth)) {
                map.get(nodeLevel).get(nodeDepth).push(node.val);
            } else {
                map.get(nodeLevel).set(nodeDepth, [node.val]);
            }
        } else {
            map.set(nodeLevel, new Map());
            map.get(nodeLevel).set(nodeDepth, [node.val]);
        }

        if (node.left !== null) {
            nodes.push({
                node: node.left,
                level: nodeLevel - 1,
                depth: nodeDepth + 1
            });
        }
        if (node.right !== null) {
            nodes.push({
                node: node.right,
                level: nodeLevel + 1,
                depth: nodeDepth + 1
            });
        }
        index++;
    }

    const result:number[][] = [];

    const levels = [...map.keys()].sort((a,b) => a-b);
    for (let i=0; i<levels.length; i++) {
        const entries:number[] = [];
        const levelMap = map.get(levels[i]);
        const depths = [...levelMap.keys()].sort((a,b) => a-b);
        for (let j=0; j<depths.length; j++) {
            const entry = levelMap.get(depths[j]).sort((a,b) => a-b);
            entries.push(...entry);
        }
        result.push(entries);
    }

    return result;

};
