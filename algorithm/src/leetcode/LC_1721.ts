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

function swapNodes(head: ListNode | null, k: number): ListNode | null {
    let start = head;

    let index = k;
    while(index > 1) {
        start = start.next;
        index--;
    }

    let temp = start.next;
    let end = head;

    while(temp !== null) {
        temp = temp.next;
        end = end.next;
    }

    const tmp = start.val;
    start.val = end.val;
    end.val = tmp;

    return head;
};
