package title.链表最大孪生和2130;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        ListNode head = new ListNode(10000);
        head = new ListNode(1, head);
        new Solution().pairSum(head);
    }
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

/*
class Solution {
    public int pairSum(ListNode head) {
        int ans = 0;
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        for (int i = ; i < list.size(); i++) {

        }
    }
}*/

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //note slow和fast都定义在head，则结束时，偶数时，slow指向后半段的开始结点；奇数时，刚好指向最中间
//        slow = reverse(slow.next);
        slow = reverse(slow);
        fast = head;
        int ans = 0;
        while (slow != null) {
            ans = Math.max(ans, slow.val + fast.val);
            slow = slow.next;
            fast = fast.next;
        }
        return ans;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}