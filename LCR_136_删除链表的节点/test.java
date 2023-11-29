package title.LCR_136_删除链表的节点;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next;}
}

/*
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode tail = dummyHead, p = tail.next;
        while (p.val != val) {
            tail = p;
            p = tail.next;
        }
        tail.next = p.next.next;
        p.next = null;
        return dummyHead.next;
    }
}*/

//method1 双指针
/*
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }
}*/

//method 2：递归
/*
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        head.next = deleteNode(head.next, val);
        return head.val == val ? head.next : head;
    }
}*/

//method 3：栈
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            if (head.val != val) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }
}