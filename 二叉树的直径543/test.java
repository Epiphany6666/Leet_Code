package title.二叉树的直径543;

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
class Solution {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs1(root);
        return ans;
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        int left = 0, right = 0;
        //note 求完树的高度不用再+1了。。。
//        if (root.left != null) left = dfs2(root.left) + 1;
//        if (root.right != null) right = dfs2(root.right) + 1;
        if (root.left != null) left = dfs2(root.left);
        if (root.right != null) right = dfs2(root.right);
        ans = Math.max(ans, left + right);
        dfs1(root.left);
        dfs1(root.right);
    }

    private int dfs2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs2(root.left), dfs2(root.right)) + 1;
    }
}*/

//method 只需要一个递归即可。。。
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }
}