package title.在二叉树中增加一行623;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
}

/**
 * 参考题解：宫水三叶
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

// method 1：BFS
class Solution1 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);
        Deque<TreeNode> d = new ArrayDeque<>();
        d.offer(root);
        int cur = 1;
        while (!d.isEmpty()) {
            int sz = d.size();
            while (sz-- > 0) {
                TreeNode t = d.poll();
                if (cur == depth  - 1) {
                    TreeNode a = new TreeNode(val), b = new TreeNode(val);
                    a.left = t.left; b.right = t.right;
                    t.left = a; t.right = b;
                } else {
                    if (t.left != null) d.offer(t.left);
                    if (t.right != null) d.offer(t.right);
                }
            }
            cur++;
        }
        return root;
    }
}

// method 2：DFS
class Solution2 {
    int v, d;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);
        v = val;
        d = depth;
        dfs(root, 1);
        return root;
    }

    private void dfs(TreeNode root, int cur) {
        if (root == null) return;
        if (cur == d - 1) {
            TreeNode a = new TreeNode(v), b = new TreeNode(v);
            a.left = root.left;
            b.right = root.right;
            root.left = a;
            root.right = b;
            return;
        }
        dfs(root.left, cur + 1);
        dfs(root.right, cur + 1);
    }
}