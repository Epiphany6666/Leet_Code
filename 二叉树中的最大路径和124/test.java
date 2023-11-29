package title.二叉树中的最大路径和124;

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

class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumDFS(root);
        return ans;
    }

    private int maxPathSumDFS(TreeNode root) {
        if (root == null) return 0;
        int left = maxPathSumDFS(root.left);
        int right = maxPathSumDFS(root.right);
        int val = root.val;
        int lim = val + Math.max(0, left) + Math.max(0, right);
        int ret = Math.max(0, Math.max(left, right)) + val;
        ans = Math.max(ans, Math.max(lim, ret));
        return ret;
    }
}