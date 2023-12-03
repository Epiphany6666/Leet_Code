package title.最深叶节点的最近公共祖先1123.overWrite02;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


/*
public class test {
}

class Solution {
    TreeNode node;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }
}*/

//果然，有些通用的做法还是要多敲
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == right) return root;

        if (left > right) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}