/**
 * Definition for node.
 * class Node {
 *     val: number
 *     children: Node[]
 *     constructor(val?: number) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.children = []
 *     }
 * }
 */

function preorder(root: Node | null): number[] {
    const result = [];

    const stack = [];

    if (root === null) {
        return result;
    }

    stack.push(root);

    while(stack.length > 0) {
        const node = stack.pop();
        for (let i=node.children.length -1; i>=0; i--) {
            stack.push(node.children[i]);
        }
        result.push(node.val);
    }


    return result;
};
