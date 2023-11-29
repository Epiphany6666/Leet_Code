package title.回文链表234;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head = new ListNode(2, head);
        new Solution().isPalindrome(head);
    }
}

/*
class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuffer sb = new StringBuffer();
        //note 自己看看你犯的什么错误
//        ListNode p1 = new ListNode();
        ListNode p1 = head;
        while (p1 != null) {
            sb.append(p1.val);
            p1 = p1.next;
        }
        StringBuffer s = new StringBuffer(sb);
        sb.reverse();
        return sb.toString().equals(s.toString());
    }
}*/

//method 2：将链表的值转化为数组
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p1 = head;
        while (p1 != null) {
            list.add(p1.val);
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l) != list.get(r)) {
                return false;
            }
        }
        return true;
    }
}