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

function isPalindrome(head: ListNode | null): boolean {
    const nodeVal = [];

    let root = head;
    let index = 0;

    while(root.next !== null) {
        nodeVal.push(root.val);
        root = root.next;
        index++;
    }
    nodeVal.push(root.val);

    let isPalindrome: boolean = true;
    for (let i=0, j=index; i<j; i++, j--) {
        const frontVal = nodeVal[i];
        const backVal = nodeVal[j];
        if (frontVal !== backVal) {
            isPalindrome = false;
            break;
        }
    }

    return isPalindrome;
};
