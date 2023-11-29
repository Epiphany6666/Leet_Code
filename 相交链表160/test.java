package title.相交链表160;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null || p1.next == null) p1 = headA;
            if (p2 == null || p2.next == null) p2 = headB;
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) return p1;
        }
        return null;
    }
}*/

//mind 每次看完题解都能震惊掉我大牙
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA == null || headB == null) return null;
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headA : p1.next;
            p2 = p2 == null ? headB : p2.next;
        }
        return p1;
    }
}