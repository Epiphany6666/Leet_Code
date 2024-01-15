package title.反转链表II92;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


//class Solution {
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode p = head, tmp = head;
//        for (int i = 1; i < left; i++) {
//            tmp = tmp.next;
//        }
//        ListNode q = tmp;
//        for (int i = 1; i < right - left + 1; i++) {
//            tmp = tmp.next;
//        }
//        ListNode r = tmp;
//}

class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode p = dummyHead, g = dummyHead.next;
        for (int i = 0; i < left - 1; i++) {
            g = g.next;
            p = p.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode removed = p.next;
//            g.next = removed;
//            p.next = removed.next;
//            removed.next = p;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }
}

//method 2：递归
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode ret = reverseN(head.next, n - 1);
        head.next.next = head.next;
        head.next = successor;
        return ret;
    }
}