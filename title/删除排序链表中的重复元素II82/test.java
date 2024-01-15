package title.删除排序链表中的重复元素II82;

import java.util.*;

public class test {
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// error
//class Solution1 {
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummyHead = new ListNode(0, head);
//        while (dummyHead.next != null && dummyHead.next.next != null) {
//            if (dummyHead.next.val == dummyHead.next.next.val) {
//                dummyHead.next = dummyHead.next.next.next;
//            } else {
//                dummyHead = dummyHead.next;
//            }
//        }
//        return head;
//    }
//}
//
//class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummyHead = new ListNode(0, head), q = dummyHead;
//        while (q.next != null && q.next.next != null) {
//            ListNode p = dummyHead.next;
//            while (p.next != null && p.val == p.next.val) {
//                p = p.next;
//            }
//            q.next = p.next;
//            q = q.next;
//        }
//        return dummyHead.next;
//    }
//}

class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
//        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
//            set.add(p.val);
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) list.add(i);
        }
        Collections.sort(list);
        ListNode dummyHead = new ListNode(-1), tail = dummyHead;
        for (Integer i : list) {
            ListNode tmp = new ListNode(i);
            tail.next = tmp;
            tail = tail.next;
        }
        return dummyHead.next;
    }
}

// method 2
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head);
        ListNode p1 = dummyHead, p2 = head;
        while (p2 != null && p2.next != null) {
            if (p1.next.val != p2.next.val) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                while (p2 != null && p2.next != null && p1.next.val == p2.next.val) {
                    p2 = p2.next;
                }
                p1.next = p2.next;
                p2 = p2.next;
            }
        }
        return dummyHead.next;
    }
}

// method 3:
class Solution3 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode p1 = dummyHead, p2 = head.next;
        while (p2 != null) {
            if (p1.next.val != p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                while (p2 != null && p1.next.val == p2.val) p2 = p2.next;
                p1.next = p2;
                p2 = p2 == null ? null : p2.next;
            }
        }
        return dummyHead.next;
    }
}

// method 4：递归
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            ListNode p = head.next;
            while (p != null && head.val == p.val) p = p.next;
            return deleteDuplicates(p);
        }
        return head;
    }
}