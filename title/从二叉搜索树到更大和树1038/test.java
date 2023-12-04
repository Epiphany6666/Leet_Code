package title.从二叉搜索树到更大和树1038;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 终于看懂题目了，这题就是中序遍历的反向遍历、、、、
 */
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

//method 1：递归
class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}

//method 2：迭代法
class Solution2 {
    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        TreeNode ans = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                TreeNode tmp = stack.pop();
                sum += tmp.val;
                tmp.val = sum;
                root = tmp.left;
            }
        }
        return ans;
    }
}

//method 2：Morris遍历
class Solution3 {
    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        TreeNode pre = null, ans = null;
        while (root != null) {
            if (root.right != null) {
                pre = root.right;
                while (pre.left != null) pre = pre.left;
                pre.left = root;
                TreeNode tmp = root;
                root = root.right;
                tmp.right = null;
            } else {
                if (ans == null) ans = root;
                sum += root.val;
                root.val = sum;
                root = root.left;
            }
        }
        return ans;
    }
}

//method Morris办法需要还原二叉树
class Solution4 {
    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        TreeNode ans = root;
        while (root != null) {
            if (root.right != null) {
                TreeNode pre = bstToGstHelper(root);
                if (pre.left == null) {
                    pre.left = root;
                    root = root.right;
                } else {
                    sum += root.val;
                    root.val = sum;
                    pre.left = null;
                    root = root.left;
                }
            } else {
                sum += root.val;
                root.val = sum;
                root = root.left;
            }
        }
        return ans;
    }

    private TreeNode bstToGstHelper(TreeNode root) {
        TreeNode pre = root.right;
        while (pre.left != null && pre.left != root) pre = pre.left;
        return pre;
    }
}