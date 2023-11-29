package title.反转链表206.overWrite3;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
}
public class test {
}

//打周赛的时候用到了翻转链表，结果又忘记了，想不起来一种方法。。。
//法1：模拟
/*class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = prev;
            prev = cur;
            cur = t;
        }
//        return cur;
        return prev;
    }
}*/

//法2：递归
/*class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
//        head.next.next = reverseList(head.next);
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}*/

//法3：妖魔化的双指针
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = temp;
        }
        return cur;
    }
}