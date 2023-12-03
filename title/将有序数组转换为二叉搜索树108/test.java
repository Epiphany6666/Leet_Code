package title.将有序数组转换为二叉搜索树108;

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

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int mid = lo + ((hi - lo) >> 1);
//        TreeNode root = new TreeNode(nums[mid]);
        TreeNode root = new TreeNode(nums[mid] - 1);
        root.left = dfs(nums, lo, mid);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }
}