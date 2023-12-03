package title.扁平化多级双向链表430;

public class test {
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(int val) {this.val = val;}
};

//method 1：递归
/*
class Solution {
    public Node flatten(Node head) {
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        while (head != null) {
            if (head.child == null) {
                head = head.next;
            } else {
                Node tmp = head.next;
                Node chead =  flatten(head.child);
                head.next = chead;
                chead.prev = head;
                while (head.next != null) head = head.next;
                head.next = tmp;
                if (tmp != null) tmp.prev = head;
                head = head.next;
            }
        }
        return dummyHead.next;
    }
}*/


/*
//method 2：递归 - 优化
class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node last = head;
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node tmp = head.next;
                Node childLast = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (tmp != null) tmp.prev = childLast;
                childLast.next = tmp;
                last = head;
                head = childLast;
            }
        }
        return last;
    }
}*/

//method 3：迭代
class Solution {
    public Node flatten(Node head) {
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        for (; head != null; head = head.next) {
            if (head.child != null) {
                Node tmp = head.next;
//                head.next = head.child;
//                head.child.prev = head;
                Node child = head.child;
                head.next = child;
                child.prev = head;
                head.child = null;
                Node last = head;
                while (last.next != null) last = last.next;
                last.next = tmp;
                if (tmp != null) tmp.prev = last;
            }
        }
        return dummyHead.next;
    }
}