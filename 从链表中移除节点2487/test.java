package title.从链表中移除节点2487;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = dummy.next;
        ListNode pre = dummy;
        int max = p1.val;
        //question 如果pre更新为p1后，p1后面依旧更大，那p1也要删除，这种情况该如何处理呢？
        while (p1 != null) {
            if (max < p1.val) {
                if (p1.next != null && p1.next.val < p1.val) continue;
                pre.next = p1;
                pre = p1;
                max = p1.val;
            } else {
                //遇到更小的需要更新
                max = p1.val;
            }
            p1 = p1.next;
        }
        return dummy.next;
    }
}*/

//mind 不管怎么改都不对。。。
/*
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = dummy.next;
        ListNode pre = dummy;
        int max = p1.val;
        //question 如果pre更新为p1后，p1后面依旧更大，那p1也要删除，这种情况该如何处理呢？
        while (p1 != null) {
            while (max < p1.val) {
                p1 = p1.val;
            }
            pre.next = p1;
            pre = p1;
            max = p1.val;

            if (max > p1.val) {
                //遇到更小的需要更新
                max = p1.val;
            }
            p1 = p1.next;
        }
        return dummy.next;
    }
}*/

//method 1：递归
/*
//mind 其实这个递归自我感觉已经做了很多次了，但是遇见时为什么还是想不到？
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode node = removeNodes(head);
        if (head.val < node.val) {
            return node;
        }
        head.next = node;
        return head;
    }
}*/


//method 2：两次反转链表
class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode p1 = head;
//        while (p1.next != null) {
        /*while (p1.next != null) {
            if (p1.val > p1.next.val) {
                p1.next = p1.next.next;
            }
            p1 = p1.next;
        }*/
        while (p1.next != null) {
            if (p1.val > p1.next.val) {
                p1.next = p1.next.next;
            } else {
                p1 = p1.next;
            }
        }
        /*head = reverse(head);
        return head;*/
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}