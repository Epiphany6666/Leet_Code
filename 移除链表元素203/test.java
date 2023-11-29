package title.移除链表元素203;
class ListNode {
    int val;
    ListNode next;
    ListNode () {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class test {
}

/*
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head.val == val) {
            head = head.next;
            if (head == null) return head;
        }
        ListNode p1 = head;
        while (p1.next != null) {
            if (p1.next.val == val) {
                p1.next = p1.next.next;
                continue;
            }
            p1 = p1.next;
        }
        return head;
    }
}*/

/*
//我的版本-简化
class Solution {
    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) return head;
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return head;
        ListNode p1 = head;//prev
        while (p1.next != null) {
            if (p1.next.val == val) {
                p1.next = p1.next.next;
//                continue;
            } else {
                p1 = p1.next;
            }
        }
        return head;
    }
}*/

/*
//法2：创建一个虚拟的头结点
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(val - 1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }
}*/


/*
//法3：递归
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}*/

//递归简化
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}