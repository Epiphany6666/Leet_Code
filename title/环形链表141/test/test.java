package title.环形链表141.test;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
public class test {
}

class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p1 = head;
        while (p1 != null) {
            if (set.contains(p1)) return true;
            set.add(p1);
            p1 = p1.next;
        }
        return false;
    }
}