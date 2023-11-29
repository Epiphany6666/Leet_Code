package title.合并两个有序链表21.overWrite02;
class ListNode {
  int val;
   ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class test {
}

//法1：迭代
/*
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 < val2) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        */
/*if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;*//*

        //简写：
        tail.next = (l1 == null ? l2 : l1);
        return dummyHead.next;
    }
}*/


//法2：递归
/*
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1.next == null) return l1;
        if (l2.next == null) return l2;
        if (l1.val < l2.val) return mergeTwoLists(l1.next, l2);
        else return mergeTwoLists(l1, l2.next);
    }
}*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
