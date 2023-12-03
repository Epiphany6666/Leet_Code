package title.路径总和112;

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

/**
 * 又没看清题。。。题目说的是 根节点到叶子节点的路径。。
 */
//class Solution {
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) return false;
//        if (dfs(root, targetSum)) return true;
//        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
//    }
//
//    private boolean dfs(TreeNode root, int targetSum) {
//        if (root == null) return false;
//        targetSum -= root.val;
//        if (targetSum == 0) return true;
//        return dfs(root.left, targetSum);
//    }
//}