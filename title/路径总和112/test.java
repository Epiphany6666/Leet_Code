package title.路径总和112;

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

//method 1：递归
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum == root.val) return true;
        //note targetSum又不一定大于0
//        if (targetSum < 0) return false;
        return hasPathSum(root.left,  targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

//method:递归简写
class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left,  targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

//method 2：BFS
class Solution3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Deque<TreeNode> queNode = new ArrayDeque<>();
        Deque<Integer> queVal = new ArrayDeque<>();

        queNode.push(root);
        queVal.push(targetSum);

        while (!queNode.isEmpty()) {
            TreeNode tmp = queNode.pop();
            int val = queVal.poll();
            if (tmp.left == null && tmp.right == null && val == tmp.val) return true;
            if (tmp.left != null) {
                queNode.push(tmp.left);
                queVal.push(val - tmp.val);
            }
            if (tmp.right != null) {
                queNode.push(tmp.right);
                queVal.push(val - tmp.val);
            }
        }
        return false;
    }
}