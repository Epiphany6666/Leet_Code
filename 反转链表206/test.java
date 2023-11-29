/*
package title.反转链表206;
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;};
    ListNode(int val, ListNode next) {this.val = val; this.next = next;};
}
public class test {
    public static void main(String[] args) {
        ListNode ans = new ListNode();
        ListNode head = CreateList();
        ans = new Solution().reverseList(ListNode head);
    }
    static ListNode CreateList() {
        ListNode head = new ListNode();
        for (int i = 0; i < 10; i++) {
            head = new ListNode(i, head);
        }
        return head;
    }
}

//法1：模拟
class Solution {
    public ListNode reverseList(ListNode head) {
        ans = new ListNode();
        ans.next = null;
        ListNode prev = null;
        for (ListNode p = head; p != null; p = p.next) {
            ListNode ans = new ListNode(p.val, ans);
        }
        return ans;
    }
}

//递归
class Solution{
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ans = new ListNode();
        ans.next = null;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
    }
}
*/

