package title.回文链表0206;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;};
    ListNode(int val, ListNode next) {this.val = val; this.next = next;};
}
public class test {
    public static void main(String[] args) {
        ListNode ans = new ListNode(10);
        for (int i = 9; i >= 0; i--) {
            ans = new ListNode(i, ans);
        }
        dispList(ans);
        boolean res = new Solution().isPalindrome(ans);
        System.out.println("res = " + res);
    }
    static void dispList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("^");
    }
}

/*//自写
class Solution {
    *//*ListNode temp = new ListNode();
    static {

    }*//*
    public boolean isPalindrome(ListNode head) {
        ListNode temp = null;
        ListNode p = head;
        while (p != null) {
            if (temp == null) temp = new ListNode(p.val);
            else temp = new ListNode(p.val, temp);
            p = p.next;
        }
        ListNode q = temp;
        for (p = head; p != null || q != null; p = p.next, q = q.next ) {
            if (p.val != q.val) return false;
        }
        if (p== null && q == null) return true;
        else return false;
    }
}*/

/*
//将值复制到数组中后用双指针
class Solution{
    public boolean isPalindrome(ListNode head) {
        List<Integer> ans = new ArrayList<Integer>();//vals
        ListNode curr = head;
        while (curr != null) {
            ans.add(curr.val);
            curr  = curr.next;
        }
        int left = 0;//front,back
        int right = ans.size() - 1;
        while (left < right) {
            if  (!ans.get(left).equals(ans.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}*/

/*
//递归
class Solution {
    private ListNode frontPoint;
    public boolean isPalindrome(ListNode head) {
        frontPoint = head;
        return recursivelyCheck(frontPoint);
    }

    public boolean recursivelyCheck(ListNode head) {//currentNode
        if (head != null) {
            if (!recursivelyCheck(head.next)) return false;
            if (frontPoint.val != head.val) return false;
            frontPoint = frontPoint.next;
        }
        return true;
    }
}*/

//快慢指针
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = endFirstHalf(head);//firstHalfEnd
        /*ListNode temp = slow;
        temp = reverseList(temp);*/
        ListNode secondHalfEnd = reverseList(slow);//secondHalfEnd
        /*ListNode p = temp;
        ListNode curr = head;
        while (*//*curr != slow && *//*temp != slow) {
            if (curr.val != temp.val) return false;
            curr = curr.next;
            temp = temp.next;
        }*/
        ListNode p1 = head;
        ListNode p2 = secondHalfEnd;
        boolean res = true;//result
        while (res && p2 != null) {
            if (p1.val != p2.val) res = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        secondHalfEnd = reverseList(secondHalfEnd);
        return res;
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        while (head.next != null) {
            ListNode t = head.next.next;
            head.next.next = curr;
            curr = head.next;
            head.next = t;
        }
        return curr;
    }

    public ListNode endFirstHalf(ListNode head) {
        ListNode first = head, slow = head;
//        while (first.next.next != null && slow.next != null) {
        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            slow = slow.next;
        }
        return slow;
    }
}