package title.节点与其祖先之间的最大差值1026;

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
 * 参考题解：灵茶山艾府
 */
// method 1：递
class Solution1 {
    private int ans;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int mn, int mx) {
        if (root == null) return;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        ans = Math.max(ans, Math.max(mx - root.val, root.val - mn));
        dfs(root.left, mn, mx);
        dfs(root.right, mn, mx);
    }
}

// method 1：优化
class Solution2 {
    private int ans;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int mn, int mx) {
        if (root == null) {
            ans = Math.max(ans, mx - mn);
            return;
        }
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        dfs(root.left, mn, mx);
        dfs(root.right, mn, mx);
    }
}

// method 2：归
class Solution {
    private int ans;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int mx = Math.max(root.val, Math.max(l[1], r[1]));
        int mn = Math.min(root.val, Math.min(l[0], r[0]));
        // note 这种方法一定是和本身结点比！！！
//        ans = Math.max(ans, mx - mn);
        ans = Math.max(ans, Math.max(mx - root.val, root.val - mn));
        return new int[] {mn, mx};
    }
}