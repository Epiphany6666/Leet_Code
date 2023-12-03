package title.反转链表206.overWrite04;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//method 1：递归
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        */
/*cur.next.next = cur;
        cur = null;*//*

        head.next.next = head;
        head.next = null;
        return cur;
    }
}*/

//method 2：模拟
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            */
/*cur = t;
            pre = cur;*//*

            pre = cur;
            cur = t;
        }
        return pre;
    }
}*/

//method 3：妖魔化的双指针
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, cur = head.next, t = head.next.next;

    }
}*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (head.next != null) {
            ListNode t = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = t;
        }
        return cur;
    }
}