package title.LCR_144_翻转二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//method 1：递归
/*
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}*/

//method 2：迭代
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        Deque<TreeNode> d = new LinkedList<>();
        if (root != null) d.offer(root);

        while (!d.isEmpty()) {
            TreeNode t = d.poll();

            TreeNode tmp = t.left;
            t.left = t.right;
            t.right = tmp;

            if (t.left != null) d.offer(t.left);
            if (t.right != null) d.offer(t.right);
        }
        return root;
    }
}