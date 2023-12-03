package title.面试题03203删除中间结点;
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
        ans.next = null;
        for (int i = 0; i < 10; i++) {
            ans = new ListNode(i, ans);
        }
        ListNode temp;
        for (temp = ans; temp.val == 3; temp = temp.next);
        dispList(ans);
        new Solution().deleteNode(temp);
        dispList(ans);
    }
    static void dispList(ListNode ans) {
        for (ListNode temp = ans; temp.val == 3; temp = temp.next) {System.out.print(temp.val + "->");};
        System.out.println("^");
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
//        node.next.next = null;

        /*//1改
        ListNode pnode = node.next;
        node.val = pnode.val;
        node.next = pnode.next;
        pnode = null;*/
    }
}
