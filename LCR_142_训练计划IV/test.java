package title.LCR_142_训练计划IV;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 还是不要眼高手低吧，以为自己已经很熟练的题目，结果一做，还是以前的写法，，还是要多敲呐
 */
/*
class Solution {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), tail = dummyHead;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        return dummyHead.next;
    }
}*/

//method 1：迭代
/*
class Solution {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}*/

//method 2：递归
class Solution {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = trainningPlan(l1.next, l2);
            return l1;
        } else{
            l2.next = trainningPlan(l1, l2.next);
            return l2;
        }
    }
}