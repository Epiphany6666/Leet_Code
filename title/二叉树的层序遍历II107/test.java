package title.二叉树的层序遍历II107;

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

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> d = new ArrayDeque<>();
        d.offer(root);
        while (!d.isEmpty()) {
            int sz = d.size();
            List<Integer> list = new ArrayList<>();
            while (sz-- > 0) {
                TreeNode t = d.poll();
                list.add(t.val);
                if (t.left != null) d.offer(t.left);
                if (t.right != null) d.offer(t.right);
            }
            ans.add(0, list);
        }
        return ans;
    }
}