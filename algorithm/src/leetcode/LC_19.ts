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

function removeNthFromEnd(head: ListNode | null, n: number): ListNode | null {

    const items = [];

    let _head = head;
    while(_head.next !== null) {
        items.push(_head.val);
        _head = _head.next;
    }
    items.push(_head.val);

    const removeIndex = items.length - n;
    if (items.length === 1) {
        return null;
    }

    let result = new ListNode();
    let nextReulst = result;
    items.forEach((item, index) => {
        if (index !== removeIndex) {
            nextReulst.val = item;
            if (index + 1 < items.length) {
                if (removeIndex === items.length - 1 && removeIndex === index + 1) {

                } else {
                    nextReulst.next = new ListNode();
                    nextReulst = nextReulst.next;
                }
            }
        }
    })

    return result;

};
