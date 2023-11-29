package tital.重排链表143;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val;this.next = next;}
}

public class test {
}

/*
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode cur = null, cur1 = null, p1 = head, p2 = head;
        while (p1.next.next != null) {
            cur = p1;
            p1 = p1.next;
            while (p2.next != null) {
                cur1 = p2;
                p2 = p2.next;
            }
            cur.next = p2;
            p2.next = p1;
            cur1.next = null;
        }
    }
}*/

/*
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}*/

/*
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}*/

//法3：寻找中间结点+反转链表+合并链表
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(head);
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
//        ListNode t = l1.next, p = l2.next;
        ListNode t, p;
        while (l1 != null && l2 != null) {
            t = l1.next;
            p = l2.next;
            l1.next = l2;
            l2.next = l1;
            l1 = t;
            l2 = p;
        }
    }

    /*//模拟
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = null, pre = head, t = pre.next;
        while (t != null) {
            cur = pre;
            pre = t;
            t = pre.next;
            pre.next = cur;
            cur.next = null;
        }
        return pre;
    }*/

    //模拟
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}