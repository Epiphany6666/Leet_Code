package title.二叉树展开为链表114;

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
//mind 与正解毫不沾边
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode newRoot = new TreeNode();
        dfs(root, newRoot);
    }

    private TreeNode dfs(TreeNode root, TreeNode newRoot) {
        if (root == null) return null;
        newRoot.left = dfs(root.left, newRoot);
        newRoot.left = dfs(root.right, newRoot);
        newRoot = new TreeNode(root.val);
        return newRoot;
    }
}*/

//method 看完解析了，只能说666，，
class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                //若左子树为空，则直接下一个结点
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) pre = pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}