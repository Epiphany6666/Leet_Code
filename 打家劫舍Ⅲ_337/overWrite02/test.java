package title.打家劫舍Ⅲ_337.overWrite02;

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

public class test {
}

/*
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
//        int money = 0;
        int money = root.val;
        if (root.left != null) money += (rob(root.left.left) + rob(root.left.right));
        if (root.right != null) money += (rob(root.right.left) + rob(root.right.right));
        map.put(root, Math.max(money, rob(root.left) + rob(root.right)));
        return map.get(root);
    }
}*/

//method 2 树形dp
class Solution {
    public int rob(TreeNode root) {
        int[] ans = myRob(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] myRob(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = myRob(root.left);
        int[] right = myRob(root.right);
        int[] dp = new int[2];
        dp[0] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}