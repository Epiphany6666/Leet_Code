function ListNode(val = 0, next = null) {
    this.val = val
    this.next = next
}

/**
 * @param {ListNode} head 
 * @returns {ListNode}
 */
var deleteDuplicates = function(head) {
    let cur = head
    while (cur && cur.next) {
        if (cur.val === cur.next.val) {
            cur.next = cur.next.next
        } else {
            cur = cur.next
        }
    }
    return head
}