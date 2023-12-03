package title.LCR_145_判断对称二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
//method 1：递归
class Solution {
    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}*/

//method 2：队列
class Solution {
    public boolean checkSymmetricTree(TreeNode root) {
        Deque<TreeNode> d = new LinkedList<>();
        if (root != null) {
            d.offer(root.left);
            d.offer(root.right);
        }
        while (!d.isEmpty()) {
            TreeNode left = d.poll();
            TreeNode right = d.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            d.offer(left.left);
            d.offer(right.right);
            d.offer(left.right);
            d.offer(right.left);
        }
        return true;
    }
}