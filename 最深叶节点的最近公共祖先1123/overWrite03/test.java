package title.最深叶节点的最近公共祖先1123.overWrite03;

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
//TODO 以前的方法
/*
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
}*/

//TODO 看了下灵神的方法，真的不得不感慨大佬就是大佬
//TODO 为什么提交完，空间使用更多了？？？但不管怎么样，这种方法还是学一下吧
/*
class Solution {
    private TreeNode ans = null;
    private int maxDepth = -1;//全局最大深度

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }

        int leftMathDepth = dfs(root.left, depth + 1);
        int rightMathDepth = dfs(root.right, depth + 1);

        if (leftMathDepth == rightMathDepth && leftMathDepth == maxDepth) {
            ans = root;
        }
        return Math.max(leftMathDepth, rightMathDepth);
    }
}*/

//TODO 法二：Pair
/*
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getValue();
    }

    public Pair<Integer, TreeNode> dfs(TreeNode node) {

    }
}*/
