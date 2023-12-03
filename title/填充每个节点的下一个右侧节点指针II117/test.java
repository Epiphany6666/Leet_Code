package title.填充每个节点的下一个右侧节点指针II117;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

/*
//mind 你瞧瞧我写的层次遍历的代码是什么鬼东西
class Solution {
    public Node connect(Node root) {
        Deque<Node> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node t = q.poll();
                if (!q.isEmpty()) t.next = q.peek();
                else t.next = null;
            }
        }
        return root;
    }
}*/

/*
class Solution {
    public Node connect(Node root) {
        Deque<Node> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node t = q.poll();
//                if (!q.isEmpty()) t.next = q.peek();
                if (size != 0) t.next = q.peek();
                else t.next = null;
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return root;
    }
}*/

//method 2：使用已建立的next指针
class Solution {
    public Node connect(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummyHead = new Node(0), pre = dummyHead;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummyHead.next;
        }
        return root;
    }
}