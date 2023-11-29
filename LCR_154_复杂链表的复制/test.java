package title.LCR_154_复杂链表的复制;


import java.util.HashMap;

public class test {
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
/*
//
method 1：拼接 + 拆分
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node p = head;
        while (p != null) {
            Node t = new Node(p.val);
            t.next = p.next;
            p.next = t;
            p = p.next.next;
        }

        p = head;
        //note 你这粗心粗的，害我检查十多分钟，，，
//        Node dummyHead = new Node(0), tail = head;
        Node dummyHead = new Node(0), tail = dummyHead;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            //note 将链表与原链表分离不能一起！因为后面的结点有可能指向前面的结点
//            tail.next = p.next;
//            tail = tail.next;
//            p = p.next.next;
        }

        p = head;
        while (p != null) {
            tail.next = p.next;
            tail = tail.next;
            //note 这里必须将两个链表分开！
//            p = p.next.next;
            p = tail.next;
            p = p.next;
        }
        return dummyHead.next;
    }
}*/

//method 2：哈希表
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node t = new Node(p.val);
            map.put(p, t);
            p = p.next;
        }

        p = head;
        while (p != null) {
            if (p.next != null)
                map.get(p).next = map.get(p.next);
            if (p.random != null)
                map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}