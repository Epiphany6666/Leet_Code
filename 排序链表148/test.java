package title.排序链表148;

import java.util.PriorityQueue;

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
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((i, j) -> j.val - i.val);
        ListNode p = head;
        while (p != null) {
            pq.offer(p);
            p = p.next;
        }

        ListNode ans = null;
        while (!pq.isEmpty()) {
            ListNode x = pq.poll();
            ans = new ListNode(x.val, ans);
        }
        return ans;
    }
}*/

//method 1：归并排序（递归法）
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //note fast要从head.next开始，才能符合： 奇数个节点找到中点，偶数个节点找到中心左边的节点。
//        ListNode fast = head, slow = head;
        ListNode fast = head.next, slow = head;
//        while (fast != null) {
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //将链表分为两半
        ListNode temp = slow.next;
        slow.next = null;

        //递归
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
//                tail = tail.next;
                left = left.next;
            } else {
                tail.next = right;
//                tail = tail.next;
                right = right.next;
            }
            //note 这句话可以提取出来
            tail = tail.next;
        }
        tail.next = left == null ? right : left;
//        return ans;
        return ans.next;
    }
}