package title.奇偶链表328;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode tail1 = odd;
        ListNode even = new ListNode(0);
        ListNode tail2 = even;
        ListNode p = head;
        int n = 1;
        while (p != null) {
            if (n % 2 != 0) {
                tail1.next = p;
                p = p.next;
                tail1 = tail1.next;
                tail1.next = null;
            } else {
                tail2.next = p;
                p = p.next;
                tail2 = tail2.next;
                tail2.next = null;
            }
            n++;
        }
        tail1.next = even.next;
        return odd.next;
    }
}*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        //note 特判
        if (head == null) return head;
        ListNode evenHead = head.next, odd = head, even = evenHead;
        while (even!= null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}