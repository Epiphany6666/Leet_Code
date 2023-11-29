package title.LCR_140_训练计划Ⅱ;

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
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && cnt-- > 0) p1 = p1.next;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}*/

//method 如果需要考虑越界：
class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && cnt-- > 0) {
            if (p1 == null) return null;
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}