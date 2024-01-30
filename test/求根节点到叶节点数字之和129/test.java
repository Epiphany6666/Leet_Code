package test.求根节点到叶节点数字之和129;

import java.util.ArrayDeque;
import java.util.Deque;

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

// BFS
class Solution1 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> nodeQ = new ArrayDeque<>();
        Deque<Integer> numQ = new ArrayDeque<>();
        nodeQ.offer(root);
        numQ.offer(root.val);
        int ans = 0;
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            Integer num = numQ.poll();
            if (node.left == null && node.right == null) {
                ans += num;
            }
            if (node.left != null) {
                nodeQ.offer(node.left);
                numQ.offer(num * 10 + node.left.val);
            }
            if (node.right != null) {
                nodeQ.offer(node.right);
                numQ.offer(num * 10 + node.right.val);
            }
        }
        return ans;
    }
}

// DFS
class Solution2 {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += val;
            return;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }
}

// DFS简写
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
}