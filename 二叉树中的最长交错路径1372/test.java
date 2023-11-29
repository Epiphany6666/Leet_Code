package title.二叉树中的最长交错路径1372;

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
//method 超时。。。
class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs1(root);
        return ans;
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        dfs2(root, 0, -1);
        dfs1(root.left);
        dfs1(root.right);
    }

    private void dfs2(TreeNode root, int depth, int status) {
        if (root == null) ans = Math.max(ans, depth);
        if (status == -1) {
            dfs2(root.left, depth + 1, 0);
            dfs2(root.right, depth + 1, 1);
        } else if (status == 0) {
            dfs2(root.right, depth + 1, 1);
        } else {
            dfs2(root.left, depth + 1, 0);
        }
    }
}*/

//method 不需要另一个递归函数啊。。。，但也超时
/*
class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        //note 你这样写距离得从-1计算
//        dfs2(root, 0, -1);
        dfs2(root, -1, -1);
        longestZigZag(root.left);
        longestZigZag(root.right);
        return ans;
    }
    private void dfs2(TreeNode root, int depth, int status) {
        if (root == null) {
            ans = Math.max(ans, depth);
            //note 总不记得加return，下面的就会越界！
            return;
        }
        if (status == -1) {
            dfs2(root.left, depth + 1, 0);
            dfs2(root.right, depth + 1, 1);
        } else if (status == 0) {
            dfs2(root.right, depth + 1, 1);
        } else {
            dfs2(root.left, depth + 1, 0);
        }
    }
}*/

//method 官解递归
/*
class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs (root, false, 0);
        dfs (root, true, 0);
        return ans;
    }

    private void dfs(TreeNode root, boolean dir, int len) {
        ans = Math.max(ans, len);
        if (dir) {
            if (root.right != null) dfs(root.right, false, len + 1);
            if (root.left != null) dfs(root.left, true, 1);
        } else {
            if (root.left != null) dfs(root.left, true, len + 1);
            if (root.right != null) dfs(root.right, false, 1);
        }
    }
}*/


//method 2：动态规划
class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int L = root.left == null ? 0 : right[1] + 1;
        int R = root.right == null ? 0 : left[0] + 1;
        ans = Math.max(ans, Math.max(L, R));
        return new int[] {L, R};
    }
}