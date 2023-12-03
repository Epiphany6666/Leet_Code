package title.LCR_155_将二叉搜索树转化为排序的双向链表;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

//method 中序遍历-迭代
/*
class Solution {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}*/

//重写
/*
class Solution {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        //note 漏了一个
        dfs(cur.right);
    }
}*/


//method 中序遍历-迭代
/*
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node head = null, pre = null;
        Deque<Node> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                Node t = stack.pop();
                if (pre != null) pre.right = t;
                else head = t;
                t.left = pre;
                pre = t;
                root = t.right;
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}*/

//method 中序遍历-莫里斯遍历
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node head = null, pre = null;
        while (root != null) {
            if (root.left != null) {
                Node p = root.left;
                while (p.right != null) p = p.right;
                p.right = root;
                Node t = root;
                root = root.left;
                t.left = null;
            } else {
                if (pre == null) head = root;
                root.left = pre;
                pre = root;
                root = root.right;
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}

/*
class Solution {
    public Node treeToDoublyList(Node root) {
        //note 特判！！！
        if (root == null) return root;
        Node head = null, pre = null;
        while (root != null) {
            if (root.left != null) {
                Node p = root.left;
                while (p.right != null) p = p.right;
                p.right = root;
                Node t = root;
                root = root.left;
                t.left = null;
            } else {
                if (pre != null) pre.right = root;
                else head = root;
                root.left = pre;
                pre = root;
                root = root.right;
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}*/
