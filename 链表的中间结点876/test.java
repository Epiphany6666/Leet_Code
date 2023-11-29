package tital.链表的中间结点876;


class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class test {
}

/*class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) return slow;
        else return slow.next;
    }
}*/

/*
//简化
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}*/

/*
//法2：数组
class Solution {
    public ListNode middleNode(ListNode head) {
//        if (head == null) return head;
        ListNode[] arr = new ListNode[100];
        int n = 0;
        while (head != null) {
            arr[n++] = head;
            head = head.next;
        }
        return arr[n / 2];
    }
}*/

//法3：单指针
class Solution {
    public ListNode middleNode(ListNode head) {
        int k = 0;
        ListNode node = head;
        while (node != null) {
            k++;
            node = node.next;
        }
        int i = 0;
        node = head;
        while (i < k / 2) {
            i++;
            node = node.next;
        }
        return node;
    }
}