package title.二叉树的最小深度111;

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
    int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        //note 居然忘记判断root是否等于空了。。
        if (root == null) return 0;
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            ans = Math.min(ans, depth);
            return;
        }
        if (root.left != null) dfs(root.left, depth + 1);
        if (root.right != null) dfs(root.right, depth + 1);
    }
}