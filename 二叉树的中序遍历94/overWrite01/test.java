package title.二叉树的中序遍历94.overWrite01;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

//method 1：递归
/*
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
/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode t = stack.pop();
                ans.add(t.val);
                root = t.right;
            }
        }
        return ans;
    }
}*/

//method 3：莫里斯遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode p = root.left;
                while (p.right != null) p = p.right;
                TreeNode t = root;
                p.right = root;
                root = root.left;
                t.left = null;
            } else {
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}