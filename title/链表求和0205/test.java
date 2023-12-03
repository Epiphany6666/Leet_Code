package title.链表求和0205;
class ListNode {
    int val;
    ListNode next;
    ListNode () {};
    ListNode (int val) {this.val = val;}
    ListNode (int val, ListNode next) {this.val = val; this.next = next;}
}
public class test {
}

/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null), ans = head;
        ListNode p1 = l1, p2 = l2;
        int cur = 0;
        while (p1 != null || p2 != null) {
            int val1 = p1 == null ? 0 : p1.val;
            int val2 = p2 == null ? 0 : p2.val;
            int sum = val1 + val2 + cur;
            ListNode temp = new ListNode(sum % 10, null);
            ans.next = temp;
            ans = ans.next;
            cur = sum / 10;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (cur != 0) {
            */
/*ListNode temp = new ListNode(cur);
            ans.next = temp;*//*

            ans.next = new ListNode(cur);
        }
        return head.next;
    }
}*/

/*
//法2：栈
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
    }
}*/
