package title.合并两个有序链表21;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class test {
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0), tail = ans;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            int n1 = p1 == null ? 101 : p1.val;
            int n2 = p2 == null ? 101 : p2.val;
            int min = 0;
            if (n1 < n2) {
                min = n1;
                p1 = p1.next;
            } else {
                min = n2;
                p2 = p2.next;
            }
            ListNode temp = new ListNode(min);
            tail.next = temp;
            tail = temp;
        }
        return ans.next;
    }
}