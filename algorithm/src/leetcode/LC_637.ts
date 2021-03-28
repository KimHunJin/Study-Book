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

function averageOfLevels(root: TreeNode | null): number[] {
    const queue: {node: TreeNode, level: number}[] = [];

    let index = 0;
    queue.push({node: root, level: 0});

    const levels = [];
    const result = [];
    while(index < queue.length) {
        const q = queue[index];
        const tree = q.node;
        const level = q.level;

        result[level] = result[level] === undefined ? tree.val : result[level] + tree.val;
        levels[level] = levels[level] === undefined ? 1 : levels[level] + 1;
        if (tree.left !== null) {
            queue.push({node: tree.left, level: level + 1});
        }
        if (tree.right !== null) {
            queue.push({node: tree.right, level: level + 1});
        }

        index++;
    }

    return result.map((it, index) => it / levels[index]);
};
