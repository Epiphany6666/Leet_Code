package title.删除链表的倒数第N个结点19;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
//method 自写，反转链表
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverseList(head);
        ListNode dummyHead = new ListNode(0, head);
        ListNode p = dummyHead, p1 = p.next;
        for (int i = 0; i < n - 1; i++) {
            p = p.next;
            p1 = p.next;
        }
        p.next = p1.next;
        p1.next = null;//help GC
//        dummyHead = reverseList(dummyHead.next);
        dummyHead.next = reverseList(dummyHead.next);
        return dummyHead.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}*/

//method 以下均为官方题解
//method 1：计算链表长度
/*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            cnt++;
            p = p.next;
        }

        int target = cnt - n;
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;
        p = pre.next;
        for (int i = 0; i < target - 1; i++) {
            pre = pre.next;
            p = pre.next;
        }
        pre.next = p.next;
        p.next = null;//help GC
        return dummyHead.next;
    }
}*/

//method 2：栈
/*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummyHead = new ListNode(0, head);
        ListNode p = dummyHead;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        ListNode cur = null;
        for (int i = 0; i < n; i++) {
            stack.poll();
        }
        cur = stack.peek();
        cur.next = cur.next.next;
        return dummyHead.next;
    }
}*/

//method 3：双指针
//question ：这是什么原理、、、
//mind 看完题解我只想说一个字：6
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead, start = pre;
        while (n > 0) {
            start = start.next;
            n--;
        }

        while (start.next != null) {
            pre = pre.next;
            start = start.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}