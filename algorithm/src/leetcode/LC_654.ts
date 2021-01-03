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

class TreeNode {
    val: number;
    left: TreeNode | null;
    right: TreeNode | null;

    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

function constructMaximumBinaryTree(nums: number[]): TreeNode | null {
    return makeTree(nums);
}

function makeTree(nums: number[]): TreeNode | null {

    if (nums.length === 0) {
        return null;
    }

    if (nums.length === 1) {
        return new TreeNode(nums[0]);
    }

    const maxIndex = nums.indexOf(Math.max(...nums));

    const leftNumbers: number[] = nums.filter((_, index) => index < maxIndex);
    const rightNumbers: number[] = nums.filter((_, index) => index > maxIndex);

    return new TreeNode(nums[maxIndex], makeTree(leftNumbers), makeTree(rightNumbers));
}
