package title.删除链表的中间节点2095;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        //note 注意特判
//        if (head == null) return null;
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            }
        pre.next = slow.next;
        slow.next = null;
        return head;
    }
}