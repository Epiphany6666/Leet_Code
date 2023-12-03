package title.环形链表2_142;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
public class test {
}

/*class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode p1 = head;
        int count = 0;
        while (p1 != null) {
            if (map.containsKey(p1)) return p1;
            map.put(p1, count++);
            p1 = p1.next;
        }
        return null;
    }
}*/

class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode pos = head;
        while (pos != null) {
            if (set.contains(pos)) return pos;
            set.add(pos);
            pos = pos.next;
        }
        return null;
    }
}