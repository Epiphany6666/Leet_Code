package title.二叉树的中序遍历94;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
//method 1：递归
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}*/

//method 2：迭代
/*class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.poll();
                root = root.right;
                ans.add(root.val);
            }
        }
        return ans;
    }
}*/

//method 3：莫里斯遍历
//mind 好牛，，，
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode pre = null;
        while (root != null) {
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) pre = pre.right;
                pre.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
            } else {
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}