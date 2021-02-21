/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */
function hasCycle(head: ListNode | null): boolean {
    let node = head;

    if (node === null) {
        return false;
    }

    while(node.next !== null) {
        if (node.val === null) {
            return true;
        }
        node.val = null;
        node = node.next;
    }
    return false;
};
