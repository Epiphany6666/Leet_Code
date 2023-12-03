package title.LCR_174_寻找二叉搜索树中的目标节点;

public class test {
}

/**
 * 性质：二叉搜索树的中序遍历为递增序列
 */

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
    int res, cnt;
    public int findTargetNode(TreeNode root, int cnt) {
        this.cnt = cnt;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (cnt == 0) return;
        if (--cnt == 0) res = root.val;
        dfs(root.left);
    }
}