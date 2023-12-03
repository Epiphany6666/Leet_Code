package title.K个一组翻转链表25;

public class test {
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //note 加一个头结点是很常见的手段了啊，，
        ListNode dummyNode = new ListNode(0, head);
        ListNode pre = dummyNode, end = dummyNode;
//        while (pre != null) {
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) return dummyNode.next;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            /*end = reverseList(start);
            start.next = next;
            pre = end = next;*/
            pre.next = reverseList(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummyNode.next;
    }

    //翻转链表
    //method 1：模拟
    /*private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }

        return pre;
    }*/

    //method 2：递归
    /*private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }*/

    //method 3：妖魔化的双指针
    private ListNode reverseList(ListNode head) {
        if (head == null) return head;
//        ListNode cur = head.next;
        ListNode cur = head;
        while (head.next != null) {
            ListNode t = cur.next;
            head.next.next = cur;
            cur = head.next;
            head.next = t;
        }
        return cur;
    }
}