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

function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
    const items = [];

    for (let i=0; i<lists.length; i++) {
        if (lists[i] === null) {
            continue;
        }
        let list = lists[i];
        while (list.next !== null) {
            items.push(list.val);
            list = list.next;
        }
        items.push(list.val);
    }



    const sortedItem = items.sort((a,b) => a-b);

    if (sortedItem.length === 0) {
        return null;
    }

    const rootNode = new ListNode();

    let currentNode = rootNode;
    for (let i=0; i<sortedItem.length; i++) {
        currentNode.val = sortedItem[i];
        if (i < sortedItem.length - 1) {
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
        }
    }

    return rootNode;

};
