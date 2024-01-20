package title.完全二叉树的节点个数222;

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

// DFS
class Solution1 {
    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return dfs(root.left) + dfs(root.right) + 1;
    }
}

// method 简写
class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

// BFS
class Solution3 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            ans++;
            if (tmp.left != null) q.offer(tmp.left);
            if (tmp.right != null) q.offer(tmp.right);
        }
        return ans;
    }
}

//method 3：上面解法确实没有好好利用完全二叉树的特点
class Solution4 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}

// method 4：二分查找
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        TreeNode node = root;
//        while (node != null) {
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, height = (1 << (level + 1)) - 1;
        while (low < height) {
            int mid = low + (height - low + 1) / 2;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                height = mid - 1;
            }
        }
        return low;
    }

    private boolean exists(TreeNode root, int level, int k) {
        int bit = 1 << (level - 1);
//        while (bit != 0) {
        while (root != null && bit > 0) {
            if ((bit & k) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            bit >>= 1;
        }
        return root != null;
    }
}