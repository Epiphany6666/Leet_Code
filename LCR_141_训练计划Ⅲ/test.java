package LCR_141_训练计划Ⅲ;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//method 1：模拟
/*class Solution {
    public ListNode trainningPlan(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }
}*/

//method 2：递归
/*
class Solution {
    public ListNode trainningPlan(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ans = trainningPlan(head.next);
        head.next.next = head;
        head.next = null;
        return ans;
    }
}*/

//method 3：妖魔化的双指针
class Solution {
    public ListNode trainningPlan(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (head.next != null) {
            ListNode t = cur.next;
            head.next.next = head;
            cur = t;
            head.next = t;
        }
        return cur;
    }
}