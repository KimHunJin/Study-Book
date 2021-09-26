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
    const r = {};
    addNode(r, root, 0, 0);
    return [...Object.keys(r)]
        .map(it => Number(it))
        .sort((a,b) => a-b)
        .map(key => r[key].sort((a,b) => a.value-b.value)
            .sort((a, b) => a.depth - b.depth)
            .map(item => item.value)
        );
};

function addNode(r, tree: TreeNode | null, x, y) {
    if (tree === null) {
        return;
    }

    const v = tree.val;
    if (r[x]) {
        r[x].push({value: v, depth: y});
    } else {
        r[x] = [{value: v, depth: y}];
    }

    addNode(r, tree.left, x - 1, y + 1);
    addNode(r, tree.right, x + 1, y + 1);
}
