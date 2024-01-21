package title.二叉搜索树的最小绝对差530;

import java.util.*;

public class test {
}

/**
 * 没注意到题目说的是二叉搜索树。。。
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

class Solution1 {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
//        Collections.sort(list);
//        return list.get(1) - list.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = i + 1; i1 < list.size(); i1++) {
                min = Math.min(min, Math.abs(list.get(i) - list.get(i1)));
            }
        }
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

//method 1：dfs
class Solution2 {
    int pre = Integer.MIN_VALUE, ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != Integer.MIN_VALUE && root.val - pre < ans) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}

// method 2：迭代
class Solution3 {
    public int getMinimumDifference(TreeNode root) {
        Integer pre = null;
        int ans = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                if (pre != null && tmp.val - pre < ans) {
                    ans = tmp.val - pre;
                }
                pre = tmp.val;
                root = tmp.right;
            }
        }
        return ans;
    }
}

// method 3：Morris算法
class Solution {
    public int getMinimumDifference(TreeNode root) {
        TreeNode pre;
        Integer p = null;
        int ans = Integer.MAX_VALUE;
        while (root != null) {
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) pre = pre.right;
                pre.right = root;
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
            } else {
                if (p != null && root.val - p < ans) {
                    ans = root.val - p;
                }
                p = root.val;
                root = root.right;
            }
        }
        return ans;
    }
}
